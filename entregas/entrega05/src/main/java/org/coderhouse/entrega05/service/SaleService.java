package org.coderhouse.entrega05.service;

import org.coderhouse.entrega05.entity.SaleModel;
import org.coderhouse.entrega05.repository.SaleRepository;
import org.coderhouse.entrega05.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public List<SaleModel> getSales() {
        return saleRepository.findAll();
    }

    public SaleModel addSale(SaleModel sale) {
        return saleRepository.save(sale);
    }

    public Optional<SaleModel> getSaleByID(Long id) {
        return saleRepository.findById(id);
    }

    public SaleModel updateSale(SaleModel existingSale, SaleModel newSale) {
        existingSale.setUser(newSale.getUser());
        return saleRepository.save(existingSale);
    }

    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }
}
