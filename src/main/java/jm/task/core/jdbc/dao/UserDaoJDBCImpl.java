package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl extends Util implements UserDao {
    // Connection connection = getConnection();


    public UserDaoJDBCImpl() {

    }


    public void createUsersTable() throws SQLException {                                 //создание таблицы юзеров
        Connection connection = getConnection();
        ;
        Statement stmt = null;

        String sql = "CREATE TABLE IF NOT EXISTS users (ID INT AUTO_INCREMENT PRIMARY KEY, NAME VARCHAR(255), LASTNAME VARCHAR(255), AGE INT)";


        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void dropUsersTable() throws SQLException {                                 //удалить таблицу юзеров
        Connection connection = getConnection();
        Statement stmt = null;
        String sql = "DROP TABLE IF EXISTS users";

        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }


    }

    public void saveUser(String name, String lastName, byte age) throws SQLException { // сохранить юзера
        if (name == null || name.isEmpty() || lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Имя и фамилия не могут быть пустыми");
        }

        Connection connection = getConnection();
        PreparedStatement stmt = null;
        String sql = "INSERT INTO users (NAME, LASTNAME, AGE) VALUES (?, ?, ?)";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, lastName);
            stmt.setByte(3, age);
            stmt.executeUpdate();
            System.out.println("User с именем " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }


    public void removeUserById(long id) throws SQLException {                           //удалить юзера по ID
        Connection connection = getConnection();
        PreparedStatement stmt = null;
        String sql = "DELETE FROM users WHERE id = ?";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

    public List<User> getAllUsers() throws SQLException {                                 //получить всех пользователей ,список юзеров
        List<User> users = new ArrayList<>();
        Connection connection = getConnection();
        Statement stmt = null;
        String sql = "SELECT * FROM users";

        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setLastName(rs.getString("lastname"));
                user.setAge(rs.getByte("age"));
                users.add(user);
                System.out.println(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return users;
    }

    public void cleanUsersTable() {                                                       //очистить таблицу пользователей
        Connection connection = getConnection();
        Statement stmt = null;
        String sql = "DELETE FROM users";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

