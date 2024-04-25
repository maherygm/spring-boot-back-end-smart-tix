package com.mahery.backendjavasmarttix.service;

import com.mahery.backendjavasmarttix.model.Product;

import java.util.List;

public interface ProductService {

    Product create(Product product);

    List<Product> get();

    Product edit(Long id , Product product);

    String delete(Long id);


}
