package com.mahery.backendjavasmarttix.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Ajoutez le chemin approprié pour vos API
                .allowedOrigins("http://localhost:5173") // Autorisez le domaine de votre application React
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Autorisez les méthodes HTTP nécessaires
                .allowedHeaders("*"); // Autorisez tous les en-têtes
    }
}
