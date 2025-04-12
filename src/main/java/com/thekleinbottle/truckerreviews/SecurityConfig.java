// package com.thekleinbottle.truckerreviews;

// import java.util.List;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;

// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;
// import org.springframework.web.cors.CorsUtils;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

// @Configuration
// public class SecurityConfig {

//   @Bean
//   CorsConfigurationSource corsConfigurationSource() {
//       CorsConfiguration configuration = new CorsConfiguration();
//       UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

//       configuration.setAllowedOrigins(List.of("*"));
//       configuration.setAllowedMethods(List.of("*"));
//       configuration.setAllowedHeaders(List.of("*"));

//       configuration.setAllowCredentials(false);
//       // configuration.setExposedHeaders(Arrays.asList("*"));
//       configuration.applyPermitDefaultValues();

//       source.registerCorsConfiguration("/**", configuration);
//       return source;
//   }
// }
