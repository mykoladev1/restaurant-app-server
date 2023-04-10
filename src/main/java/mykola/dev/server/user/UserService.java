package mykola.dev.server.user;

import jakarta.transaction.Transactional;
import mykola.dev.server.user.validation.SurnameValidation;
import mykola.dev.server.user.validation.UsernameValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements UsernameValidation, SurnameValidation {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(UUID id) {
        if (userRepository.findById(id) == null) {
            throw new IllegalStateException("User does not exists");
        }
        return userRepository.findById(id);
    }

    public void addUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()) {
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

    public void deleteUser(String id) {
        UUID uuid = UUID.fromString(id);
        deleteUser(uuid);
    }
    @Transactional
    public void updateUser(UUID id, String name, String surname) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("student with id" + id + "does not exists"));

        // TODO
        // Тутай замінити на validateUsername()
        if (name != null && name.length() > 0 && !Objects.equals(user.getName(), name)) {
            user.setName(name);
        }

        // TODO
        // тутай теж
        if (surname != null && surname.length() > 0 && !Objects.equals(user.getSurname(), surname)) {
            user.setSurname(surname);
        }
    }

    // TODO
    @Override
    public boolean validateUsername() {
        return true;
    }

    // TODO
    @Override
    public boolean validateSurname() {
        return true;
    }
}

