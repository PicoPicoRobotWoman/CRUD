package web.Service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    void create(User user);
    void remove(User user);
    void update(User user);
    User getUserById(Long id);
}
