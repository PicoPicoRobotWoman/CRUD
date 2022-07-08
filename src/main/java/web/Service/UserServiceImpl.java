package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.Dao.UserDao;
import web.Dao.UserDaoImpl;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao dao;

    @Transactional
    @Override
    public List<User> allUsers() {
        return dao.AllUsers();
    }

    @Transactional
    @Override
    public void create(User user) {
        dao.create(user);
    }

    @Transactional
    @Override
    public void remove(User user) {
        dao.remove(user);
    }

    @Transactional
    @Override
    public void update(User user) { dao.update(user); }

    @Transactional
    @Override
    public User getUserById(Long id) {
        return dao.getUsetById(id);
    }
}
