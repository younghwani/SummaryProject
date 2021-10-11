package com.younghwani.summarize.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    //크로스 도메인 이슈를 해결하기 위한 코드이다.

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**").allowCredentials(true).allowedOrigins("http://localhost:3000");
    }
}
