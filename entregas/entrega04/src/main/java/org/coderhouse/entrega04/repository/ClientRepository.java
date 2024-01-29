package org.coderhouse.entrega04.repository;

import org.coderhouse.entrega04.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientModel, Long> {
}