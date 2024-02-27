package coderhouse.proyectoFinal.controller;

import coderhouse.proyectoFinal.entity.SaleDTO;
import coderhouse.proyectoFinal.entity.SaleModel;
import coderhouse.proyectoFinal.service.SaleService;
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
    public ResponseEntity<?> addSale(@RequestBody SaleDTO sale) {
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