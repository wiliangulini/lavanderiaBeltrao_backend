package com.marina.springlavanderia.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration(proxyBeanMethods = false)
public class CorsConfig {

  @Value("${cors.allowed.origins:http://localhost:4200,http://31.97.160.61,https://31.97.160.61,http://lavanderiabeltrao.com.br,https://lavanderiabeltrao.com.br,http://www.lavanderiabeltrao.com.br,https://www.lavanderiabeltrao.com.br}")
  private String allowedOrigins;

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {

      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins(allowedOrigins.split(","))
            .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
            .allowedHeaders("*")
            .allowCredentials(true)
            .maxAge(3600);
      }

    };
  }

}
