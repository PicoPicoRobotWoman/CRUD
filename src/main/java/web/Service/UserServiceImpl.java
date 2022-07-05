package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.Dao.UserDao;
import web.Dao.UserDaoImpl;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao dao;

    @Override
    public List<User> allUsers() {
        return dao.AllUsers();
    }

    @Override
    public void add(User user) {
        dao.add(user);
    }

    @Override
    public void delete(User user) {
        dao.delete(user);
    }

    @Override
    public void edit(User user) {
        dao.edit(user);
    }

    @Override
    public User getUserById(Long id) {
        return dao.detUsetById(id);
    }
}
