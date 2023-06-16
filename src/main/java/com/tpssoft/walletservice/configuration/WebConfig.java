//package com.tpssoft.walletservice.configuration;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Configuration
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
//public class WebConfig 	implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedHeaders("*")
//                .allowedMethods("POST", "GET", "OPTIONS", "DELETE", "PUT", "PATCH")
//                .allowedOrigins("*");
//    }
//}
