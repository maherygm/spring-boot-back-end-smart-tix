package com.mahery.backendjavasmarttix.service;

import com.mahery.backendjavasmarttix.model.Product;
import com.mahery.backendjavasmarttix.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImplement  implements ProductService{

    private final ProductRepository productRepository;
    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> get() {
        return productRepository.findAll();
    }

    @Override
    public Product edit(Long id, Product product) {
        Product produitsNonTrouver = productRepository.findById(id).map(p -> {
            p.setNom(product.getNom());
            p.setPrix(product.getPrix());
            p.setDescription(product.getDescription());
            return productRepository.save(p);
        }).orElseThrow(() -> new RuntimeException("Produits non trouver"));
        return produitsNonTrouver;
    }
    @Override
    public String delete(Long id) {
        productRepository.deleteById(id);
        return "Produits Supprimer";
    }
}
