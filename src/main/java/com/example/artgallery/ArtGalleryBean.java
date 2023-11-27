package com.example.artgallery;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ArtGalleryBean {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}


