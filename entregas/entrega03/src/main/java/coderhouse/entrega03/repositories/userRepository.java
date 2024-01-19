package coderhouse.entrega03.repositories;

import coderhouse.entrega03.models.userModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<userModel, Long> {

}
