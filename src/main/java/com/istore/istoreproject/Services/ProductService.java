package com.istore.istoreproject.Services;

import java.util.List;

import com.istore.istoreproject.models.Product;


public interface ProductService {

    Product saveProduct(Product product , List<Long> connectivityIds);

    Product updateProduct(Product product, long id);

    Product getById(long id);

    List<Product> findAll();
}
