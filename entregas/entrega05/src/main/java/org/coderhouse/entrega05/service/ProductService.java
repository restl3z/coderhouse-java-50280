package org.coderhouse.entrega05.service;

import org.coderhouse.entrega05.entity.ProductModel;
import org.coderhouse.entrega05.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> getProducts() {
        return productRepository.findAll();
    }

    public ProductModel addProduct(ProductModel product) {
        return productRepository.save(product);
    }

    public Optional<ProductModel> getProductByID(Long id) {
        return productRepository.findById(id);
    }

    public ProductModel updateProduct(ProductModel existingProduct, ProductModel newProduct) {
        existingProduct.setName(newProduct.getName());
        existingProduct.setPrice(newProduct.getPrice());
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
