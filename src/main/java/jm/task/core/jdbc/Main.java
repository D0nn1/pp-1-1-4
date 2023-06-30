package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;



public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        for (int i = 65; i < 70; i++) {
            char buf = (char) i;
            userService.saveUser(String.valueOf(buf), String.valueOf((char) (buf + 1)), (byte) i);
            System.out.println("пользователь с именем " + ((char) i) + " добавлен");
        }
        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();



    }
}
