package com.thekleinbottle.truckerreviews;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.thekleinbottle.truckerreviews.service.UserDetailsServiceImpl;

@Configuration
public class SecurityConfig {
  private UserDetailsServiceImpl userDetailsService;

  public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
    this.userDetailsService = userDetailsService;
  }

  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
  }

  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    UserDetails user = User.builder().username("user").password(passwordEncoder()
      .encode("password")).roles("USER").build();

    return new InMemoryUserDetailsManager(user);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
      CorsConfiguration configuration = new CorsConfiguration();
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

      configuration.setAllowedOrigins(List.of("*"));
      configuration.setAllowedMethods(List.of("*"));
      configuration.setAllowedHeaders(List.of("*"));

      configuration.setAllowCredentials(false);
      // configuration.setExposedHeaders(Arrays.asList("*"));
      configuration.applyPermitDefaultValues();

      source.registerCorsConfiguration("/**", configuration);
      return source;
  }
}
