package com.mahery.backendjavasmarttix.service.location;


import com.mahery.backendjavasmarttix.model.Location;
import com.mahery.backendjavasmarttix.repository.LocationRepository;
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
public class LocationServiceImplement implements LocationService {

    private final LocationRepository locationRepository;

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
    public Location create(Location location , MultipartFile image_vr , MultipartFile image_profil) {


        try {
            String filename_vr = image_vr.getOriginalFilename();
            String cleanFileName_vr = generateCleanFilename(filename_vr,"VR");
            Path destinationFile_vr = rootLocation.resolve(Paths.get(cleanFileName_vr)).normalize().toAbsolutePath();
            Files.copy(image_vr.getInputStream(), destinationFile_vr);

            String filename_profil = image_profil.getOriginalFilename();
            String cleanFileName_profil = generateCleanFilename(filename_profil,"PROFIL");
            Path destinationFile_profil = rootLocation.resolve(Paths.get(cleanFileName_profil)).normalize().toAbsolutePath();
            Files.copy(image_profil.getInputStream(), destinationFile_profil);

            location.setImage_vr_path(cleanFileName_vr);
            location.setImage_profil_path(cleanFileName_profil);

            return locationRepository.save(location);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }
    public static String generateCleanFilename(String originalFilename , String types) {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String formattedDate = dateFormat.format(currentDate);
        String cleanFilename = formattedDate + "-" + types + "-" + originalFilename.replaceAll("[^a-zA-Z0-9.-]", "_");
        return cleanFilename;
    }

    @Override
    public List<Location> get() {
        return locationRepository.findAll();
    }

    @Override
    public String delete(long id) {
        locationRepository.deleteById(id);
        return null;
    }

}
