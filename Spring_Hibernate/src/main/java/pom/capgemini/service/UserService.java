package pom.capgemini.service;

import pom.capgemini.entity.User;
import java.util.List;

public interface UserService {
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Integer id);
    User getUserById(Integer id);
    List<User> getAllUsers();
}

