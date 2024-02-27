package coderhouse.proyectoFinal.repository;

import coderhouse.proyectoFinal.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {

}
