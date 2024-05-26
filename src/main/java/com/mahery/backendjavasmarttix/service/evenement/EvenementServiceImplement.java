package com.mahery.backendjavasmarttix.service.evenement;
import com.mahery.backendjavasmarttix.repository.EvenementRepository;
import com.mahery.backendjavasmarttix.model.Evenement;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@AllArgsConstructor
public class EvenementServiceImplement implements EvenementService {

    private final EvenementRepository eventRepository;
    private final Path rootLocation = Paths.get("upload-dir");

    @PostConstruct
    public void init() {
        try {
            if (!Files.exists(rootLocation)) {
                Files.createDirectories(rootLocation);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage location", e);
        }
    }
    @Override
    public Evenement create(Evenement evenement , MultipartFile file) {


        try {
            String filename = file.getOriginalFilename();
            String cleanFileName = generateCleanFilename(filename);
            Path destinationFile = rootLocation.resolve(Paths.get(cleanFileName)).normalize().toAbsolutePath();
            Files.copy(file.getInputStream(), destinationFile);
            evenement.setImage_path(cleanFileName);
            return eventRepository.save(evenement);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }
    public static String generateCleanFilename(String originalFilename) {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String formattedDate = dateFormat.format(currentDate);
        String cleanFilename = formattedDate + "-" + originalFilename.replaceAll("[^a-zA-Z0-9.-]", "_");
        return cleanFilename;
    }
    @Override
    public List<Evenement> get() {
        return eventRepository.findAll();
    }
    @Override
    public Evenement delete(long id) {
       Evenement ev =  eventRepository.getById(id);
        eventRepository.deleteById(id);
        return ev;
    }
    @Override
    public Path getImagePath(String filename) {
        return rootLocation.resolve(filename);
    }
}
