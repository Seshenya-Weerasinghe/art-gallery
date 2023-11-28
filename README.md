# Art Gallery Application

This Spring Boot application gets the images of an art-gallery.

## Introduction

The Art Gallery Application is a simple Spring Boot application designed to get details of art items available at https://api.artic.edu/api/v1

## Modules

- **ApiController:** Handles HTTP requests, and interacts with the service layer.
- **ApiService:** Contains the business logic for application.
- **ArtGalleryBean:** Spring configuration class that defines a bean for a RestTemplate, which can be injected into other components for making HTTP requests in the Art Gallery application.
- **ArtworksApiResponse:** Java model class representing the response structure from an art gallery API, containing pagination details, artwork data, information, and configuration attributes.
- **ArtGalleryApplication:** Entry point for the Spring Boot application.

# Getting Started

To get started with the Art Gallery Application, clone the repository and follow the build and run instructions below.

## Clone Repository 

```
git clone https://github.com/Seshenya-Weerasinghe/art-gallery.git

cd art-gallery
```

The application will be accessible locally at localhost:8080

## API Endpoints

Get the artworks:
```
GET /artworks
```
