package com.HomeFluent.Homeaccount.Security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{

    public WebConfig() {
    }
@Value("${cors.allowedOrigins}")
private String allowedOrigins;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // TODO Auto-generated method stub
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**").allowedOrigins(allowedOrigins.split(","))
        .allowedMethods("*").allowedHeaders("*");
    }
    
}
