package com.example.artgallery.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ArtworksApiResponse {
    public ArtworksApiResponse() {
    }

    private Pagination pagination;
    private List<Artwork> data;
    private Info info;
    private Config config;

    // Getters and setters
    @Getter
    @Setter
    static class Pagination {
        private int total;
        private int limit;
        private int offset;
        private int total_pages;
        private int current_page;
        private String next_url;
    }

    // Getters and setters
    @Getter
    @Setter
    static class Artwork {
        private int id;
        private String title;
        private String artist_display;
    }

    // Getters and setters
    @Getter
    @Setter
    static class Info {
        private String license_text;
        private List<String> license_links;
        private String version;
    }

    // Getters and setters
    @Getter
    @Setter
    static class Config {
        private String iiif_url;
        private String website_url;
    }

}






