/*
package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        try (Connection connection = Util.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "CREATE TABLE IF NOT EXISTS users (" +
                             "id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                             "name VARCHAR(255), " +
                             "last_name VARCHAR(255), " +
                             "age TINYINT)")) {
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create table", e);
        }

    }

    public void dropUsersTable() {

        try (Connection connection = Util.getConnection();
             PreparedStatement ps = connection.prepareStatement("DROP TABLE IF EXISTS users")) {
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to drop table", e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = Util.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "INSERT INTO users (name, last_name, age) VALUES (?, ?, ?)")) {
            ps.setString(1, name);
            ps.setString(2, lastName);
            ps.setByte(3, age);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save user", e);
        }
    }

    public void removeUserById(long id) {

        try (Connection connection = Util.getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "DELETE FROM users WHERE id = ?")) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to remove user", e);
        }
    }

    public List<User> getAllUsers() {
        try (Connection connection = Util.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM users");
             ResultSet rs = ps.executeQuery()) {

            List<User> users = new ArrayList<>();
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String lastName = rs.getString("last_name");
                byte age = rs.getByte("age");
                users.add(new User(name, lastName, age));
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to get users", e);
        }
    }

    public void cleanUsersTable() {
        try (Connection connection = Util.getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM users")) {
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to clean table", e);
        }

    }
}
*/
