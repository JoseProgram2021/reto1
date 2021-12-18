package usa.ciclo4.reto1.repository.crud;

import org.springframework.data.repository.CrudRepository;
import usa.ciclo4.reto1.model.User;

import java.util.Optional;

public interface UserCrudRepository extends CrudRepository <User, Integer> {

    Optional<User> findByEmail (String email);
    Optional<User> findByEmailAndPassword (String email, String password);

}
