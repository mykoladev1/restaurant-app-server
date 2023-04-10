package mykola.dev.server.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(UUID id) {
        if(userRepository.findById(id) == null) {
            throw new IllegalStateException("User does not exists");
        }
        return userRepository.findById(id);
    }

    public void addUser(User user) {
        Optional<User> userOptional =
                userRepository.findUserByEmail(user.getEmail());
        if(userOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        userRepository.save(user);

    }

    public void deleteUser(UUID id) {
        userRepository.findById(id);
        boolean exists = userRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("student with id" + id + "does not exists");
        }
        userRepository.deleteById(id);
    }
    @Transactional
    public void updateUser(UUID id, String name, String surname) {
            User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("student with id" + id + "does not exists"));
                if(name != null && name.length()>0 && !Objects.equals(user.getName(), name)) {
                    user.setName(name);
                }
                System.out.println(name);
                if(surname != null && surname.length()>0 && !Objects.equals(user.getSurname(), surname)) {
                    user.setSurname(surname);
                }
                System.out.println(surname);
    }
    }

