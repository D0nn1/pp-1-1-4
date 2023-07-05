package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.SQLGrammarException;
import java.util.List;
import java.util.function.Function;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try {
            run(session -> session.createSQLQuery("CREATE TABLE `mydbtest`.`" + "users" + "` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(45) NOT NULL,\n" +
                    "  `lastName` VARCHAR(45) NOT NULL,\n" +
                    "  `age` INT(3) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;").executeUpdate());
        } catch (SQLGrammarException g) {

        }


    }

    @Override
    public void dropUsersTable() {
        run(session -> session.createSQLQuery("DROP TABLE IF EXISTS " + "users").executeUpdate());

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        run(session -> session.save(new User(name, lastName, age)));

    }


    @Override
    public void removeUserById(long id) {
        run(session -> session.createQuery("delete User" + " where id = " + id).executeUpdate());
    }

    @Override
    public List<User> getAllUsers() {
        return run(session -> session.createQuery("FROM User", User.class).list());
    }

    @Override
    public void cleanUsersTable() {
        run(session -> session.createQuery("delete User").executeUpdate());
    }


    private static <T> T run(Function<Session, T> function) {
        SessionFactory factory = Util.getFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        T t = function.apply(session);
        session.getTransaction().commit();
        factory.close();
        return t;
    }


}
