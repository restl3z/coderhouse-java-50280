package org.coderhouse.entrega05.controller;

import org.coderhouse.entrega05.entity.ProductModel;
import org.coderhouse.entrega05.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "products", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getProducts() {
        List<ProductModel> foundProducts = productService.getProducts();
        if (!foundProducts.isEmpty()) {
            return ResponseEntity.ok(foundProducts);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "products", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addProduct(@RequestBody ProductModel product) {
        try {
            ProductModel addedProduct = productService.addProduct(product);
            return ResponseEntity.created(URI.create("")).body(addedProduct);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping(value = "products/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getProductByID(@PathVariable(name = "id") Long id) {
        Optional<ProductModel> foundProduct = productService.getProductByID(id);
        if (foundProduct.isPresent()) {
            return ResponseEntity.ok(foundProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "products/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> updateProduct(@PathVariable(name = "id") Long id, @RequestBody ProductModel product) {
        Optional<ProductModel> foundProduct = productService.getProductByID(id);
        if (foundProduct.isPresent()) {
            ProductModel modifiedProduct = productService.updateProduct(foundProduct.get(), product);
            return ResponseEntity.ok(modifiedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "products/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteProduct(@PathVariable(name = "id") Long id) {
        Optional<ProductModel> foundProduct = productService.getProductByID(id);
        if (foundProduct.isPresent()) {
            productService.deleteProduct(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
