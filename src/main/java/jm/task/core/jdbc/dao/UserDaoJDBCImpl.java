package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private static final String name_of_table = "users";


    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Connection connection = connection(); Statement statement = statement(connection)) {
            statement.execute("CREATE TABLE `mydbtest`.`" + name_of_table + "` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(45) NOT NULL,\n" +
                    "  `lastName` VARCHAR(45) NOT NULL,\n" +
                    "  `age` INT(3) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        try (Connection connection = connection(); Statement statement = statement(connection)) {
            statement.execute("DROP TABLE IF EXISTS " + name_of_table);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        try (Statement statement = statement()) {
            statement.executeUpdate("insert into users (name, lastName, age) values ('" + name + "', '" + lastName + "', " + (int) age + ");");
        } catch (SQLException e) {
            if (!e.getSQLState().equals("42S02")) {
                throw new RuntimeException(e);
            }
        }
    }

    public void removeUserById(long id) {
        try (Statement statement = statement()) {
            if (statement.executeQuery("SELECT COUNT(*) FROM Users WHERE id = " + id).next()) {
                statement.execute("delete from users where id = " + id + ";");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Statement statement = statement()) {
            ResultSet resultSet = statement.executeQuery("select * from " + name_of_table + ";");
            while (resultSet.next()) {
                User user = new User(resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getByte("age"));
                user.setId(resultSet.getLong("id"));
                users.add(user);

            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanUsersTable() {
        try (Statement statement = statement()) {
            statement.executeUpdate("DELETE FROM " + name_of_table);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    private Connection connection() throws SQLException {
        return Util.getConnection();
    }

    private Statement statement() throws SQLException {
        return Util.getStatement();
    }

    private Statement statement(Connection connection) throws SQLException {
        return connection.createStatement();
    }

}
