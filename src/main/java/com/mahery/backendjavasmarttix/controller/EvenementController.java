package com.mahery.backendjavasmarttix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mahery.backendjavasmarttix.model.Evenement;
import com.mahery.backendjavasmarttix.service.evenement.EvenementService;
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
@RequestMapping("/api/evenement")
@AllArgsConstructor
public class EvenementController {

    private final EvenementService evenementService;

    @PostMapping
    public Evenement  create(HttpServletRequest request, @RequestParam("image") MultipartFile image , @RequestParam("evenement") String evenementJson ) {
        ObjectMapper objectMapper = new ObjectMapper();
        Evenement evenement = null;
        try {
            evenement = objectMapper.readValue(evenementJson, Evenement.class);
        } catch (IOException e) {
             System.out.println(String.valueOf(new ResponseEntity<>("Invalid evenement JSON", HttpStatus.BAD_REQUEST)));
        }
        String baseUrl = String.format("%s://%s:%d/api/images/", request.getScheme(), request.getServerName(),request.getServerPort());
        Evenement evenement1 =   evenementService.create(evenement, image);
        evenement1.setImage_path(baseUrl + evenement.getImage_path());
        return evenement1;
    }
    @GetMapping
    public List<Evenement> getAll(HttpServletRequest request) {
        List<Evenement> evenements = evenementService.get();


        String baseUrl = String.format("%s://%s:%d/api/images/", request.getScheme(), request.getServerName(),request.getServerPort());
        return evenements.stream().map(evenement  -> {
            evenement.setImage_path(baseUrl + evenement.getImage_path());
            return evenement;
        }).collect(Collectors.toList());
    }
    @DeleteMapping({"{id}"})
    public String delete(@PathVariable Long id) {
        return evenementService.delete(id);
    }
//    @GetMapping("/images/{filename:.+}")
//    @ResponseBody
//    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
//        try {
//            Path file = evenementService.getImagePath(filename);
//            Resource resource = new UrlResource(file.toUri());
//            return ResponseEntity.ok()
//                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                    .body(resource);
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
