package com.example.artgallery.controller;
import com.example.artgallery.model.ArtworksApiResponse;
import com.example.artgallery.service.ApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/artworks")
    public ResponseEntity<ArtworksApiResponse> getArtWorks() {
        // Call the API through the service
        ResponseEntity<ArtworksApiResponse> responseEntity = apiService.callApi();
        return responseEntity;
    }
}
