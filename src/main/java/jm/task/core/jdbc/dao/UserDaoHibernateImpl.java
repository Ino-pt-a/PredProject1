package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.Collections;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try (Session session = Util.getConnection().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery(
                    "CREATE TABLE IF NOT EXISTS users (" +
                            "id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                            "name VARCHAR(255), " +
                            "last_name VARCHAR(255), " +
                            "age TINYINT)"
            ).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = Util.getConnection().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS users").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = Util.getConnection().openSession()) {
            session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user);
            session.getTransaction().commit();
            System.out.println("User  " + name + " saved.");
        } catch (Exception e) {
            e.getMessage();
        }

    }

    @Override
    public void removeUserById(long id) {
        try (Session session = Util.getConnection().openSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
           session.delete(user);
           session.getTransaction().commit();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = Util.getConnection().openSession()) {
            session.beginTransaction();
            List<User> list = session.createQuery("FROM User", User.class).getResultList();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = Util.getConnection().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM User").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
