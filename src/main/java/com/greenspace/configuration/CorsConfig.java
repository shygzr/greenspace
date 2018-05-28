//package com.greenspace.configuration;
//
//import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//public class CorsConfig extends WebMvcConfigurationSupport{
//
//   @Override
//    protected void addCorsMappings(CorsRegistry registry) {
//       registry.addMapping("/**")
//               .allowedOrigins("*")
//               .allowCredentials(true)
//               .allowedMethods("GET","POST","DELETE","PUT")
//                .maxAge(3600);
//    }
//}
