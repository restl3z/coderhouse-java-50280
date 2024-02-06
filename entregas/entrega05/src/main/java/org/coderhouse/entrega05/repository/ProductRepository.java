package org.coderhouse.entrega05.repository;

import org.coderhouse.entrega05.entity.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {

}
