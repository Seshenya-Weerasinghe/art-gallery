package com.example.artgallery.service;
import com.example.artgallery.model.ArtworksApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ApiService {

    private static final Logger logger = LoggerFactory.getLogger(ApiService.class);

    @Value("${api.url}")
    private String apiUrl; // Inject API URL from application.properties

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public ApiService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    String fields = "id,title,artist_display";

    public ResponseEntity<ArtworksApiResponse> callApi() {
        String endpoint = "/artworks";
        String updatedApiUrl = UriComponentsBuilder
                .fromUriString(apiUrl + endpoint)
                .queryParam("fields", fields)
                .build()
                .toUriString();
        // Make a GET request to the API
        ResponseEntity<ArtworksApiResponse> responseEntity = restTemplate.getForEntity(updatedApiUrl, ArtworksApiResponse.class);
        try {
            // Convert the response body to JSON
            String responseBodyJson = objectMapper.writeValueAsString(responseEntity.getBody());
            logger.info("API Result body: {}", responseBodyJson);
        } catch (JsonProcessingException error) {
            logger.error("Error converting response body to JSON", error);
        }
        logger.info("API Result status code: {} ", responseEntity.getStatusCode());
        logger.info("API Result headers: {}", responseEntity.getHeaders());
        return responseEntity;
    }

}
