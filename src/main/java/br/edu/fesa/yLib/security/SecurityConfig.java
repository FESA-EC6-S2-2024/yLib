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
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .formLogin((form) -> form.loginPage("/login").permitAll())
        .logout((logout) -> logout.permitAll());

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
