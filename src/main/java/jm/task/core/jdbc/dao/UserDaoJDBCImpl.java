package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public static Statement statement;

    static {
        try {
            statement = Util.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        try {
            dropUsersTable();
            statement.executeUpdate("CREATE TABLE users (" +
                    "id int auto_increment primary key," +
                    "name varchar(30) not null," +
                    "lastName varchar(10) not null," +
                    "age tinyint not null)");
        } catch (SQLException ignored) {
        }
    }

    public void dropUsersTable() {
        try {
            statement.executeUpdate("DROP TABLE Users");
        } catch (SQLException ignored) {
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            statement.executeUpdate("INSERT INTO users (name, lastName, age)" +
                    " value ('" + name + "', '" + lastName + "', '" + age +"')");
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException ignored) {
        }
    }

    public void removeUserById(long id) {
        try {
            statement.executeUpdate("DELETE FROM users WHERE id = " + id);
        } catch (SQLException ignored) {
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                userList.add(new User(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getByte(4)
                ));
            }
        } catch (SQLException ignored) {
        }
        return userList;
    }

    public void cleanUsersTable() {
        try {
            statement.executeUpdate("DELETE FROM users");
        } catch (SQLException ignored) {
        }
    }
}