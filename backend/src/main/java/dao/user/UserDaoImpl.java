package dao.user;

import dao.Dao;
import model.user.User;

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

    @PersistenceContext
    private EntityManagerFactory factory;

    @Override
    public User create(User entity) {

        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(entity);
            transaction.commit();
        } catch (Exception e) {

            transaction.rollback();
        } finally {
            em.close();
        }

        return entity;
    }

    @Override
    public List<User> findAll() {

        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery("SELECT u FROM User u");

        List<User> result = query.getResultList();

        em.close();

        return result;

    }

    @Override
    public List<User> findAll(int offset, int length) {


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
            return null;
        }

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
            return null;
        }

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
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }

        return old;
    }

}
