package com.istore.istoreproject.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.istore.istoreproject.Services.ProductService;
import com.istore.istoreproject.models.Connectivity;
import com.istore.istoreproject.models.Product;
import com.istore.istoreproject.repositories.ConnectivityRepo;
import com.istore.istoreproject.repositories.ProductRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final ConnectivityRepo connectivityRepo;

    @Override
    public Product saveProduct(Product product, List<Long> connectivityIds) {
        List<Connectivity> connectivities = connectivityRepo.findAllById(connectivityIds);
        product.setConnectivityOptions(connectivities);
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Product updatedProduct, long id) {
        // Check if the product with the given ID exists in the database
        Product existingProduct = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existingProduct.getConnectivityOptions().clear();

        updatedProduct.getConnectivityOptions().forEach(option -> {
            Connectivity connectivity = connectivityRepo.findById(option.getId()).orElseThrow();
            existingProduct.getConnectivityOptions().add(connectivity);
        });

        // Update the fields of the existing product with the values from the updated
        // product
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setColor(updatedProduct.getColor());
        existingProduct.setQuantity(updatedProduct.getQuantity());
        existingProduct.setRefernece(updatedProduct.getRefernece());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setRam(updatedProduct.getRam());
        existingProduct.setBatteryCapacity(updatedProduct.getBatteryCapacity());
        existingProduct.setOperatingSystem(updatedProduct.getOperatingSystem());

        // Save and return the updated product
        return productRepo.save(existingProduct);
    }

    @Override
    public Product getById(long id) {
        return productRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

}
