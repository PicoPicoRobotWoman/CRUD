package web.Dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.*;
import javax.transaction.SystemException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {


    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static final Map<Long, User> users = new HashMap<>();

    {
        User user1 = new User("name" + 1, 21);
        User user2 = new User("name" + 2, 22);
        User user3 = new User("name" + 3, 23);
        User user4 = new User("name" + 4, 24);
        User user5 = new User("name" + 5, 25);

        this.add(user1);
        this.add(user2);
        this.add(user3);
        this.add(user4);
        this.add(user5);

    }

    @Override
    public List<User> AllUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void add(User user) {

        users.put(user.getId(), user);
    }

    @Override
    public void delete(User user) {
        users.remove(user.getId());
    }

    @Override
    public void edit(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User detUsetById(Long id) {
        return users.get(id);
    }
}
