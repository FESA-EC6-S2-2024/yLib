package br.edu.fesa.yLib.security;

import br.edu.fesa.yLib.model.User;
import br.edu.fesa.yLib.repository.UserRepository;
import java.util.List;
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
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

/**
 * @author Grupo_7
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

  @Autowired private UserRepository userRepository;

  @Autowired private CustomAuthenticationSuccessHandler successHandler;

  @Autowired private CustomAuthenticationFailureHandler failureHandler;

  @Autowired private CustomLogoutSuccessHandler logoutSuccessHandler;

  @Bean
  public SessionListener sessionListener() {
    return new SessionListener();
  }

  @Bean
  public RequestCache requestCache() {
    return new HttpSessionRequestCache();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
            (authorize) ->
                authorize
                    .requestMatchers(
                        "/", "/home", "/auth/login", "/auth/register", "/css/**", "/images/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .formLogin(
            (form) ->
                form.loginPage("/auth/login")
                    .successHandler(successHandler)
                    .failureHandler(failureHandler)
                    .permitAll())
        .logout(
            (logout) ->
                logout
                    .logoutUrl("/auth/logout")
                    .logoutSuccessHandler(logoutSuccessHandler)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .permitAll())
        .sessionManagement(
            (session) ->
                session
                    .sessionFixation()
                    .migrateSession()
                    .maximumSessions(1)
                    .expiredSessionStrategy(
                        event -> {
                          String URI = event.getRequest().getRequestURI();
                          System.out.println("URI=" + URI);
                          if (URI.endsWith(".html")) {
                            event.getResponse().sendRedirect("/auth/login?expired=true");
                          } else {
                            event.getResponse().setContentType("application/json");
                            event
                                .getResponse()
                                .sendError(440, "Session has expired. Please login again!");
                          }
                        }))
        .exceptionHandling((exc) -> exc.accessDeniedPage("/error/forbidden")); // 403 error page
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
    return new BCryptPasswordEncoder(12);
  }
}
