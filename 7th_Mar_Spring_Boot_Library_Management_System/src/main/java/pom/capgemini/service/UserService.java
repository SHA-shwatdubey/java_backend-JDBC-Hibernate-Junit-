package pom.capgemini.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pom.capgemini.entity.User;
import pom.capgemini.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }

    public User createUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists: " + user.getUsername());
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists: " + user.getEmail());
        }

        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);

        if (!user.getUsername().equals(userDetails.getUsername())
                && userRepository.existsByUsername(userDetails.getUsername())) {
            throw new RuntimeException("Username already exists: " + userDetails.getUsername());
        }

        if (!user.getEmail().equals(userDetails.getEmail())
                && userRepository.existsByEmail(userDetails.getEmail())) {
            throw new RuntimeException("Email already exists: " + userDetails.getEmail());
        }

        user.setUsername(userDetails.getUsername());
        user.setFullName(userDetails.getFullName());
        user.setEmail(userDetails.getEmail());

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
}


