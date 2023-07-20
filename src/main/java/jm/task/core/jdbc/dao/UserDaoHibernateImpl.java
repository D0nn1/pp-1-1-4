package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
//    private final SessionFactory sessionFactory = Util.getFactory();

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
//        Session session = null;
//        try {
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            session.createSQLQuery("CREATE TABLE IF NOT EXISTS `mydbtest`.`users` (\n" +
//                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
//                    "  `name` VARCHAR(45) NOT NULL,\n" +
//                    "  `lastName` VARCHAR(45) NOT NULL,\n" +
//                    "  `age` INT(3) NULL,\n" +
//                    "  PRIMARY KEY (`id`))\n" +
//                    "ENGINE = InnoDB\n" +
//                    "DEFAULT CHARACTER SET = utf8;").executeUpdate();
//            session.getTransaction().commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            if (session.getTransaction() != null) {
//                session.getTransaction().rollback();
//            }
//        } finally {
//            session.close();
//        }
    }


    @Override
    public void dropUsersTable() {
//        Session session = null;
//        try {
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            session.createSQLQuery("DROP TABLE IF EXISTS users").executeUpdate();
//            session.getTransaction().commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            if (session.getTransaction() != null) {
//                session.getTransaction().rollback();
//            }
//        } finally {
//            session.close();
//        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
//        Session session = null;
//        try {
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            session.save(new User(name, lastName, age));
//            session.getTransaction().commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            if (session.getTransaction() != null) {
//                session.getTransaction().rollback();
//            }
//        } finally {
//            session.close();
//        }
    }


    @Override
    public void removeUserById(long id) {
//        Session session = null;
//        try {
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            session.delete(session.get(User.class, id));
//            session.getTransaction().commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            if (session.getTransaction() != null) {
//                session.getTransaction().rollback();
//            }
//        } finally {
//            session.close();
//        }
    }

    @Override
    public List<User> getAllUsers() {
//        Session session = null;
//        try {
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            return session.createQuery("FROM User", User.class).list();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            if (session.getTransaction() != null) {
//                session.getTransaction().rollback();
//            }
//        } finally {
//            session.close();
//        }
        return null;
    }

    @Override
    public void cleanUsersTable() {
//        Session session = null;
//        try {
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            session.createQuery("delete User").executeUpdate();
//            session.getTransaction().commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            if (session.getTransaction() != null) {
//                session.getTransaction().rollback();
//            }
//        } finally {
//            session.close();
//        }
    }


//    private  <T> T run(Function<Session, T> function) {
//        Session session = null;
//        try {
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            T t = function.apply(session);
//            session.getTransaction().commit();
//            return t;
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            if (session.getTransaction() != null) {
//                session.getTransaction().rollback();
//            }
//        } finally {
//            session.close();
//        }
//        return null;
//    }


}
