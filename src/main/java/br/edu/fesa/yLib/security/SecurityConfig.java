package br.edu.fesa.yLib.security;

import br.edu.fesa.yLib.model.User;
import br.edu.fesa.yLib.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Grupo7
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Autowired private UserRepository userRepository;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
            (requests) ->
                requests
                    .requestMatchers("/", "/home", "/css/**", "/images/**")
                    .permitAll() // Todos os usuários podem acessar
                    .requestMatchers("/admin/**")
                    .hasRole("ADMIN") // Somente usuários com a role "ADMIN" podem acessar /admin/**
                    .requestMatchers("/loan/**")
                    .hasAnyRole(
                        "ADMIN",
                        "LIBRARIAN") // Somente usuários com "ADMIN" ou "LIBRARIAN" podem acessar /loan/**
                    .anyRequest()
                    .authenticated())
        .formLogin(
            (form) ->
                form.loginPage("/login") // Esta é a URL que o Spring Security usa para login
                    .defaultSuccessUrl("/home", true) // Redireciona após o login
                    .permitAll())
        .logout(
            (logout) ->
                logout
                    .logoutUrl("/logout") // Esta é a URL que o Spring Security usa para logout
                    .logoutSuccessUrl("/home") // Redireciona após o logout
                    .invalidateHttpSession(true) // Invalida a sessão
                    .deleteCookies("JSESSIONID") // Remove o cookie de sessão
                    .permitAll())
        .sessionManagement(
            (session) ->
                session
                    .maximumSessions(1) // Limita a uma sessão por usuário
                    .maxSessionsPreventsLogin(true) // Evita que o usuário faça login
            // novamente se já tiver uma sessão ativa
            )
        .accessDeniedPage("/access-denied"); // Página de acesso negado;
    return http.build();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    return username -> {
      User user =
          userRepository
              .findByEmail(username)
              .orElseThrow(() -> new UsernameNotFoundException("User not found"));

      return new CustomUserDetails(
          user.getEmail(),
          user.getPassword(),
          user.getName(),
          user.getImage(),
          true,
          user.isUsing2FA(),
          List.of(new SimpleGrantedAuthority("ROLE_" + user.getUserType().name())));
    };
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
