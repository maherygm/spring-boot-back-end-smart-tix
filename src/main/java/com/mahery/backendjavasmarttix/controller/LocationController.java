package com.mahery.backendjavasmarttix.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mahery.backendjavasmarttix.service.location.LocationService;
import com.mahery.backendjavasmarttix.model.Location;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/location")
@AllArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @PostMapping
    public Location create(HttpServletRequest request,@RequestParam("image-vr") MultipartFile image_vr ,@RequestParam("image-profil") MultipartFile image_profil , @RequestParam("location") String locationJson ) {
        ObjectMapper objectMapper = new ObjectMapper();
        Location location = null;
        try {
          location = objectMapper.readValue(locationJson, Location.class);
       } catch (IOException e) {
            System.out.println(String.valueOf(new ResponseEntity<>("Invalid location JSON", HttpStatus.BAD_REQUEST)));
       }

        String baseUrl = String.format("%s://%s:%d/api/images/", request.getScheme(), request.getServerName(),request.getServerPort());

        Location location1 =  locationService.create(location, image_vr , image_profil);
        location1.setImage_profil_path(baseUrl + location.getImage_profil_path());
        location1.setImage_vr_path(baseUrl + location.getImage_vr_path());

        return  location1;
    }
    @GetMapping
    public List<Location> getAll(HttpServletRequest request) {
        List<Location> locations = locationService.get();

        String baseUrl = String.format("%s://%s:%d/api/images/", request.getScheme(), request.getServerName(),request.getServerPort());
        return locations.stream().map(location -> {
            location.setImage_profil_path(baseUrl + location.getImage_profil_path());
            location.setImage_vr_path(baseUrl + location.getImage_vr_path());
            return location;
        }).collect(Collectors.toList());
    }
    @DeleteMapping({"{id}"})
    public String delete(@PathVariable Long id) {
        return locationService.delete(id);
    }

}
