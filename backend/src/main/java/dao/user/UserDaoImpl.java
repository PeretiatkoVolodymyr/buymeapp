package dao.user;

import dao.Dao;
import model.user.User;
import org.apache.log4j.Logger;

import javax.persistence.*;
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
public class UserDaoImpl implements Dao<User, Integer> {

    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    @PersistenceContext
    private EntityManagerFactory factory;

    @Override
    public User create(User entity) {

        if (entity == null) {
            LOGGER.error("CREATE. entity is null");
            return null;
        }

        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(entity);
            transaction.commit();
            LOGGER.info("save new user");
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.info("User not save rollback");
        } finally {
            em.close();
        }

        return entity;
    }

    @Override
    public List<User> findAll() {

        LOGGER.info("search for all Users (without limits)");

        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery("SELECT u FROM User u");

        List<User> result = query.getResultList();

        em.close();

        return result;

    }

    @Override
    public List<User> findAll(int offset, int length) {

        if (offset < 0 || length < 0) {
            LOGGER.error("Offset or/and length is less then 0");
            return null;
        }

        LOGGER.info("search for all Users (with limits)");

        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery("SELECT u FROM User u");

        query.setMaxResults(length);
        query.setFirstResult(offset);

        List<User> result = query.getResultList();

        em.close();

        return result;
    }

    @Override
    public User find(Integer id) {

        if (id == null || id < 0) {
            LOGGER.error("User id is null or is less then 0");
            return null;
        }

        LOGGER.info("search for single User by id");

        EntityManager em = factory.createEntityManager();

        User found;

        try {
            found = em.find(User.class, id);
        } finally {
            em.close();
        }

        return found;
    }

    @Override
    public User remove(Integer id) {

        if (id == null || id < 0) {
            LOGGER.error("User id is null or is less then 0");
            return null;
        }

        LOGGER.info("remove single User by id");

        EntityManager em = factory.createEntityManager();

        User entity = em.find(User.class, id);

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.remove(entity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }

        return entity;
    }

    @Override
    public User update(User entity) {

        if (entity == null) {
            LOGGER.error("User entity is null");
            return null;
        }

        User old = null;

        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            old = em.find(User.class, entity.getId());
            em.merge(entity);
            transaction.commit();
            LOGGER.info("update");
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.info("User not update rollback");
        } finally {
            em.close();
        }

        return old;
    }

}
