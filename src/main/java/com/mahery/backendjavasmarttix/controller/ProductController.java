package com.mahery.backendjavasmarttix.controller;


import com.mahery.backendjavasmarttix.model.Product;
import com.mahery.backendjavasmarttix.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produit")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PostMapping
    public Product create(@RequestBody Product product){

        Product product1 = productService.create(product);
        return product1;
    }

    @GetMapping
    public List<Product> getAll(){
        List<Product> products = productService.get();
        return products;
    }

    @PutMapping("{id}")
    public Product updtate(@PathVariable Long id , @RequestBody Product product){
        return productService.edit(id, product);
    }

    @DeleteMapping({"{id}"})
    public String delete(@PathVariable Long id){
        return productService.delete(id);
    }

}
