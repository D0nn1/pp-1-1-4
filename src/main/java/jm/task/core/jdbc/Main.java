package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        for (int i = 65; i < 70; i++) {
            userService.saveUser(String.valueOf((char) i++), String.valueOf((char) i--), (byte) (0.5 * i - i % 2));
            System.out.printf("User с именем – %s добавлен в базу данных \n", (char) i);
        }
        userService.getAllUsers().forEach(System.out::println);
        userService.removeUserById(15);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
