package dev.logue.app.config;

import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Spring Security Configure.
 *
 * @author logue
 * @since 1.0.0
 * @version 1.0.2
 */
@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  /**
   * {@inheritDoc}
   *
   * <p>Make different security settings for each URL.
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    log.info("🔐 Security Configure");
    http.authorizeRequests()
        // Exclude Setting
        .antMatchers("/", "/js/**", "/css/**", "/img/**", "/api/**", "/v3/**")
        .permitAll()
        .anyRequest()
        .authenticated()
        // Login Setting
        .and()
        .formLogin()
        .loginProcessingUrl("/api/login")
        .usernameParameter("name")
        .passwordParameter("password")
        // When login succeed, output 201 Accepted to status code..
        .successHandler((req, res, auth) -> res.setStatus(HttpServletResponse.SC_ACCEPTED))
        // When login failure, output 401 Unauthorized to status code.
        .failureHandler((req, res, auth) -> res.setStatus(HttpServletResponse.SC_UNAUTHORIZED))
        // Logout setting
        .and()
        .logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/api/logout"))
        // When logout succeed, output 201 Accepted to status code.
        .logoutSuccessHandler((req, res, auth) -> res.setStatus(HttpServletResponse.SC_ACCEPTED))
        .invalidateHttpSession(true)
        // CSRF
        .and()
        .csrf()
    // .disable()
    ;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Load user data.
   *
   * @param auth Authentication
   * @throws java.lang.Exception if any.
   */
  @Autowired
  protected void configureAuthenticationManager(AuthenticationManagerBuilder auth)
      throws Exception {
    // DUMMY
    auth.inMemoryAuthentication()
        .withUser("user")
        // Password: pass
        .password("$2y$12$YUZZ5S6OaKygVbQPf.GElebkSuGCajsLZGTaSiXE7Zopz7fs2Z622")
        .roles("USER");
  }

  /**
   * Form values are also encrypted (Compatible with laravel).
   *
   * @return {@link org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder} Cryptographic
   *     algorithm
   */
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
