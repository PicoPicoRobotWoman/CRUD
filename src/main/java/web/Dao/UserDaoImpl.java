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

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> AllUsers() {
        String JPAql = "select user from User user";
        return entityManager.createQuery(JPAql, User.class).getResultList();

    }

    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    public void remove(User user) {
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUsetById(Long id) {
        return entityManager.find(User.class, id);
    }
}
