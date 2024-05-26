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
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.ProductCreateParams;

@RestController
@RequestMapping("/api/evenement")
@AllArgsConstructor
public class EvenementController {

    private final EvenementService evenementService;

    @PostMapping
    public Evenement create(HttpServletRequest request, @RequestParam("image") MultipartFile image , @RequestParam("evenement") String evenementJson ) throws StripeException {
        ObjectMapper objectMapper = new ObjectMapper();
        Evenement evenement = null;

        System.out.println(evenementJson);
        try {
            evenement = objectMapper.readValue(evenementJson, Evenement.class);
        } catch (IOException e) {
             System.out.println(String.valueOf(new ResponseEntity<>("Invalid evenement JSON", HttpStatus.BAD_REQUEST)));
        }
        String baseUrl = String.format("%s://%s:%d/api/images/", request.getScheme(), request.getServerName(),request.getServerPort());


        Stripe.apiKey = "sk_test_51PJbJVFCA4Yw8qTq8YMSAMpQhdqPq5Ll7mtnidXBRkaf0q4hByCN9F5Jldmu93DYu1qLDfAMPZTAkYrs10jn95HH00zClN7rCc";

        ProductCreateParams params =
                ProductCreateParams.builder()
                        .setName(evenement.getTitre_event())
                        .setDefaultPriceData(
                                ProductCreateParams.DefaultPriceData.builder()
                                        .setUnitAmount(evenement.getPrix())
                                        .setCurrency("mga")
                                        .build()
                        )
                        .addExpand("default_price")
                        .build();
        Product product = Product.create(params);
        Price defaultPrice = product.getDefaultPriceObject();

        evenement.setEvent_id_stripe(product.getId());
        evenement.setPrice_id(defaultPrice.getId());

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
    public Evenement delete(@PathVariable Long id) {
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
