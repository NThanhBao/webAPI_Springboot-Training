package com.example.demo.service.serviceImpl;



import com.example.demo.model.entity.Products;
import com.example.demo.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Product entities.
 */
@Service
public class ProductService {

    private final ProductRepo productRepository;

    @Autowired
    public ProductService(ProductRepo productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Save a product.
     *
     * @param product the entity to save
     * @return the persisted entity
     */
    public Products saveProduct(Products product) {
        return productRepository.save(product);
    }

    /**
     * Get all the products.
     *
     * @return the list of entities
     */
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Get one product by ID.
     *
     * @param id the ID of the entity
     * @return the entity
     */
    public Optional<Products> getProductById(Long id) {
        return productRepository.findById(id);
    }

    /**
     * Update a product.
     *
     * @param id the ID of the entity
     * @param updatedProduct the updated entity
     * @return the updated entity
     */
    public Products updateProduct(Long id, Products updatedProduct) {
        Optional<Products> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Products product = existingProduct.get();
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setQuantity(updatedProduct.getQuantity());
            return productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    /**
     * Delete the product by ID.
     *
     * @param id the ID of the entity
     */
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

