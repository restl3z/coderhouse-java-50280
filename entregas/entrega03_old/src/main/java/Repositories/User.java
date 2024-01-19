package Repositories;

import org.springframework.data.repository.CrudRepository;

public interface User extends CrudRepository<Models.User, Integer> {
}
