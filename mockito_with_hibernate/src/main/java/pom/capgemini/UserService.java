package pom.capgemini;

public class UserService {

    private UserDao dao;

    // Constructor Injection
    public UserService(UserDao dao) {
        this.dao = dao;
    }

    public User getUserById(int id) {
        return dao.findById(id);
    }
}
