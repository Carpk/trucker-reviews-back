// package com.thekleinbottle.truckerreviews;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration
// public class CorsConfig {
//   @Bean
//   public WebMvcConfigurer corsConfigurer() {
//     return new WebMvcConfigurer() {
//       @Override
//       public void addCorsMappings(CorsRegistry registry) {
//         registry.addMapping("/api/**") // Configure the path pattern
//                 .allowedOrigins("*") // Replace with your frontend origin
//                 .allowedMethods("*")
//                 .allowedHeaders("*")
//                 .allowCredentials(true);
//       }
//     };
//   }
// }
