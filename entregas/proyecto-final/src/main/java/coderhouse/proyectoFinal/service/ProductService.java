package coderhouse.proyectoFinal.service;

import coderhouse.proyectoFinal.entity.ProductModel;
import coderhouse.proyectoFinal.repository.ProductRepository;
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

    public List<ProductModel> getProductByIDs(List<Long> ids) {
        return productRepository.findAllById(ids);
    }

    public ProductModel updateProduct(ProductModel existingProduct, ProductModel newProduct) {
        existingProduct.setName(newProduct.getName());
        existingProduct.setPrice(newProduct.getPrice());
        existingProduct.setStock(newProduct.getStock());
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
