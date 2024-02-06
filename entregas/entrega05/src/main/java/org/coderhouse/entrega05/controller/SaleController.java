package org.coderhouse.entrega05.controller;

import org.coderhouse.entrega05.entity.SaleModel;
import org.coderhouse.entrega05.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping(value = "sales", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getSales() {
        List<SaleModel> foundSales = saleService.getSales();
        if (!foundSales.isEmpty()) {
            return ResponseEntity.ok(foundSales);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "sales", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addSale(@RequestBody SaleModel sale) {
        try {
            SaleModel addedSale = saleService.addSale(sale);
            return ResponseEntity.created(URI.create("")).body(addedSale);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping(value = "sales/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getSaleByID(@PathVariable(name = "id") Long id) {
        Optional<SaleModel> foundSale = saleService.getSaleByID(id);
        if (foundSale.isPresent()) {
            return ResponseEntity.ok(foundSale);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "sales/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> updateSale(@PathVariable(name = "id") Long id, @RequestBody SaleModel sale) {
        Optional<SaleModel> foundSale = saleService.getSaleByID(id);
        if (foundSale.isPresent()) {
            SaleModel modifiedSale = saleService.updateSale(foundSale.get(), sale);
            return ResponseEntity.ok(modifiedSale);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "sales/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteSale(@PathVariable(name = "id") Long id) {
        Optional<SaleModel> foundSale = saleService.getSaleByID(id);
        if (foundSale.isPresent()) {
            saleService.deleteSale(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}