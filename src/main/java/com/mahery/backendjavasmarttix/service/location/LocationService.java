package com.mahery.backendjavasmarttix.service.location;
import com.mahery.backendjavasmarttix.model.Evenement;
import com.mahery.backendjavasmarttix.model.Location;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Path;
import java.util.List;
public interface LocationService {

    Location create(Location location , MultipartFile image_vr ,MultipartFile image_profil);
    List<Location> get();
    String delete(long id);

}
