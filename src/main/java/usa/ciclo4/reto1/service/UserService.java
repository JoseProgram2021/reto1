package usa.ciclo4.reto1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo4.reto1.model.User;
import usa.ciclo4.reto1.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    public User register (User user) {
        if (user.getId() == null) {
            if (existEmail(user.getEmail()) == false) {
                return userRepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
        public boolean existEmail (String email) {
            return userRepository.existEmail(email);
        }

        public User userAutentication (String email, String password) {
            Optional <User> user1 = userRepository.userAutentication(email, password);

                if (user1.isEmpty()) {
                    return new User(email, password, "NO DEFINIDO");
                } else {
                    return user1.get();
                }
        }
    }

