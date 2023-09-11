package com.smm.map.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebMvcConfig implements WebMvcConfigurer {
	
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer.addPathPrefix("/${spring.application.name}/api", (clazz)->true);
//    }
    
    @Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/v1").allowedOrigins("http://localhost:3000");
	}
}