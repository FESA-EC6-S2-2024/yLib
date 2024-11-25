package br.edu.fesa.yLib.security;

import br.edu.fesa.yLib.enumerator.UserType;
import br.edu.fesa.yLib.model.User;
import br.edu.fesa.yLib.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

  @Autowired
  private UserRepository userRepository;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((authorize) -> authorize
            .requestMatchers("/", "/home", "/auth/register", "/css/**", "/images/**").permitAll()
            // .requestMatchers("/loans/**").hasAnyRole(UserType.ADMIN.name(), UserType.LIBRARIAN.name())
            // .requestMatchers("/loans/client").hasRole(UserType.CLIENT.name())
            .anyRequest().authenticated())
        .formLogin((form) -> form
            .loginPage("/auth/login")
            .successHandler(new SavedRequestAwareAuthenticationSuccessHandler())
            // .defaultSuccessUrl("/home", true)
            .failureUrl("/auth/login?error=true")
            .permitAll())
        .logout((logout) -> logout
            .logoutUrl("/auth/logout")
            .logoutSuccessUrl("/auth/login")
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
            .permitAll())
        .sessionManagement((session) -> session
            .maximumSessions(1) // Ensures only one session per user is active
            .expiredUrl("/auth/login")) // Redirect to login if session expires
        .exceptionHandling((exc) -> exc
            .accessDeniedPage("/error/forbidden")); // 403 error page
    return http.build();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    return username -> {
      User user = userRepository
          .findByEmail(username)
          .orElseThrow(() -> new UsernameNotFoundException("User not found"));

      return new CustomUserDetails(
          user.getEmail(),
          user.getPassword(),
          user.getName(),
          user.getImage(),
          true,
          user.isUsing2FA(),
          List.of(new SimpleGrantedAuthority("ROLE_" + user.getUserType().name())) // usando enum UserType para definir
                                                                                   // role
      );
    };
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
