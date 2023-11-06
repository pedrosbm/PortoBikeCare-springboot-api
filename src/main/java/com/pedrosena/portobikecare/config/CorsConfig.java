package com.pedrosena.portobikecare.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permitir todos os caminhos
            .allowedOrigins("http://localhost:5173") // Especifique a origem do seu aplicativo React
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permitir todos os métodos
            .allowedHeaders("Content-Type")
            .allowCredentials(true);
    }
}
