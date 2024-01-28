package coderhouse.entrega03.controllers;

import coderhouse.entrega03.models.saleModel;
import coderhouse.entrega03.repositories.productRepository;
import coderhouse.entrega03.repositories.saleRepository;
import coderhouse.entrega03.repositories.userRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class saleController {

    @Autowired
    private saleRepository repo;

    @GetMapping("sales")
    public List<saleModel> getSales() {
        return repo.findAll();
    }

    @PostMapping("sales")
    public String addSale(@RequestBody saleModel sale) {
        repo.save(sale);
        return "Sale saved";
    }

    @PutMapping("sales/{id}")
    public String updateSales(@PathVariable Long id, @RequestBody saleModel sale) {
        saleModel foundSale = repo.findById(id).get();
        foundSale.setProduct(sale.getProduct());
        foundSale.setProductName(sale.getProductName());
        foundSale.setUser(sale.getUser());
        foundSale.setUserName(sale.getUserName());
        foundSale.setUserEmail(sale.getUserEmail());
        repo.save(foundSale);
        return "Sale modified.";
    }

    @DeleteMapping("sales/{id}")
    public String deleteSale(@PathVariable Long id) {
        repo.deleteById(id);
        return "Sale deleted.";
    }
}
