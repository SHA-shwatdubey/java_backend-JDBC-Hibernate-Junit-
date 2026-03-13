package pom.capgemini.dao;

import pom.capgemini.entity.User;
import java.util.List;

public interface UserDAO {
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Integer id);
    User getUserById(Integer id);
    List<User> getAllUsers();
}

