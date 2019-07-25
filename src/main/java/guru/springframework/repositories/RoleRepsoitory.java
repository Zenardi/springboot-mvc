package guru.springframework.repositories;

import guru.springframework.domain.security.Role;
import org.springframework.data.repository.CrudRepository;


public interface RoleRepsoitory extends CrudRepository<Role, Integer> {

}