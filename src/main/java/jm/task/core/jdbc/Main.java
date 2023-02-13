package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        //Session session = Util.getConnection().openSession();
        //System.out.println(session.get(User.class, 1L).toString());

        //UserDao userDao = new UserDaoJDBCImpl();
        UserDao userDao = new UserDaoHibernateImpl();

        userDao.dropUsersTable();
        userDao.createUsersTable();



        userDao.saveUser("Name1", "LastName1", (byte) 20);
        userDao.saveUser("Name2", "LastName2", (byte) 25);
        userDao.saveUser("Name3", "LastName3", (byte) 31);
        userDao.saveUser("Name4", "LastName4", (byte) 38);

        userDao.removeUserById(1);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
