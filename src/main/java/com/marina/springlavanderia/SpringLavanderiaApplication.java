package com.marina.springlavanderia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
// extends SpringBootServletInitializer
@SpringBootApplication
public class SpringLavanderiaApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringLavanderiaApplication.class, args);
  }

//  @Override
//  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//    return application.sources(SpringLavanderiaApplication.class);
//  }

}
