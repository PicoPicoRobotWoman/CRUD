package web.Dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> AllUsers();
    void create(User user);
    void remove(User user);
    void update(User user);
    User getUsetById(Long id);

}
