package coderhouse.entrega03.repositories;

import coderhouse.entrega03.models.productModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<productModel, Long> {

}
