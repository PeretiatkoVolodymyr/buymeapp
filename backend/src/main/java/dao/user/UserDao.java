package dao.user;

import dao.Dao;
import model.user.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Implementation of general DAO interface. Used to work
 * with stored User entity instances.
 *
 * @author PeretiatkoVolodymyr
 * @version 0.1
 *
 * @see Dao
 */
public class UserDao implements Dao<User, Integer> {

    private EntityManagerFactory factory;

    @Override
    public User create(User entity) {

        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(entity);
            transaction.commit();
        } catch (Exception e) {

            transaction.rollback();
        } finally {
            manager.close();
        }

        return entity;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findAll(int offset, int length) {
        return null;
    }

    @Override
    public User find(Integer id) {

        if (id == null || id < 0) {
            return null;
        }

        EntityManager manager = factory.createEntityManager();

        try {
            return manager.find(User.class, id);
        } finally {
            manager.close();
        }
    }

    @Override
    public User remove(Integer id) {

        if (id == null || id < 0) {
            return null;
        }

        EntityManager manager = factory.createEntityManager();

        User entity = manager.find(User.class, id);

        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.remove(entity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            manager.close();
        }

        return entity;
    }

    @Override
    public User update(User entity) {
        return null;
    }

}
