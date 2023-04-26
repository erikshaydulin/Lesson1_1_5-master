package jm.task.core.jdbc.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import javax.persistence.Query;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private final Session session = Util.getSessionFactory().openSession();
    private Transaction transaction = null;

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try {
            transaction = session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS Users(id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(45), lastname VARCHAR(64), age TINYINT);").executeUpdate();
            transaction.commit();
        }   catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void dropUsersTable() {
        try {
            transaction = session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS users").executeUpdate();
            transaction.commit();
        }   catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {

            transaction = session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void removeUserById(long id) {
        try {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = Util.getSessionFactory().openSession()) {
            return session.createQuery("from User", User.class).list();
        }
    }

    @Override
    public void cleanUsersTable() {
        try {
            transaction = session.beginTransaction();
            session.createQuery("delete User").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
