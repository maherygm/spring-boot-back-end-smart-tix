package com.mahery.backendjavasmarttix.service.evenement;
import com.mahery.backendjavasmarttix.model.Evenement;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

public interface EvenementService {


    Evenement create(Evenement event , MultipartFile file);
    List<Evenement> get();

    String delete(long id);
    Path getImagePath(String filename);
}
