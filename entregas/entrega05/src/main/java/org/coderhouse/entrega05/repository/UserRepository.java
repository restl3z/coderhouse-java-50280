package org.coderhouse.entrega05.repository;

import org.coderhouse.entrega05.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {

}
