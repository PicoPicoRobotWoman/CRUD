package web.Dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> AllUsers();
    void add(User user);
    void delete(User user);
    void edit(User user);
    User detUsetById(Long id);

}
