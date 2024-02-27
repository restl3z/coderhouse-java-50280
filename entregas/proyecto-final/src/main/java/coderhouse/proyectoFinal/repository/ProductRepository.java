package coderhouse.proyectoFinal.repository;

import coderhouse.proyectoFinal.entity.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {

}
