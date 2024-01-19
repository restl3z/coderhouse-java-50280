package coderhouse.entrega03.controllers;
import coderhouse.entrega03.models.productModel;
import coderhouse.entrega03.repositories.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class productController {

    @Autowired
    private productRepository repo;

    @GetMapping("products")
    public List<productModel> getProducts(){
        return repo.findAll();
    }

    @PostMapping("products")
    public String addProduct(@RequestBody productModel product){
        repo.save(product);
        return "Product saved";
    }

    @PutMapping("products/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody productModel product)
    {
        productModel foundProduct = repo.findById(id).get();
        foundProduct.setName(product.getName());
        foundProduct.setPrice(product.getPrice());
        repo.save(foundProduct);
        return "Product modified.";
    }

    @DeleteMapping("products/{id}")
    public String deleteProduct(@PathVariable Long id)
    {
        repo.deleteById(id);
        return "Product deleted.";
    }
}
