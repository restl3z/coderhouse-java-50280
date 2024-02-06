package org.coderhouse.entrega05.controller;

import org.coderhouse.entrega05.entity.SaleItemModel;
import org.coderhouse.entrega05.repository.SaleItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SaleItemController {

    @Autowired
    private SaleItemRepository repo;

    @GetMapping("sale_items")
    public List<SaleItemModel> getSales() {
        return repo.findAll();
    }

    @PostMapping("sale_items")
    public String addSale(@RequestBody SaleItemModel sale_item) {
        repo.save(sale_item);
        return "Sale Item saved";
    }

    @PutMapping("sale_items/{id}")
    public String updateSale(@PathVariable Long id, @RequestBody SaleItemModel sale_item) {
        String response = "Sale Item does not exist.";
        if (repo.findById(id).isPresent()) {
            SaleItemModel foundSaleItem = repo.findById(id).get();
            foundSaleItem.setSale(sale_item.getSale());
            foundSaleItem.setProduct(sale_item.getProduct());
            foundSaleItem.setQuantity(sale_item.getQuantity());
            repo.save(foundSaleItem);
            response = "Sale Item modified.";
        }
        return response;
    }

    @DeleteMapping("sale_items/{id}")
    public String deleteSale(@PathVariable Long id) {
        String response = "Sale Item does not exist.";
        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
            response = "Sale Item deleted.";
        }
        return response;
    }
}
