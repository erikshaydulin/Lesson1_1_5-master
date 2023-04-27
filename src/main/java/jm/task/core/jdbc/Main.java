package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        UserService usi = new UserServiceImpl();
        usi.createUsersTable();
        usi.saveUser("Nikita", "Salamandrov", (byte) 25);
        usi.saveUser("Zaur", "Tregulov", (byte) 29);
        usi.saveUser("Erik", "Shaydulin", (byte) 31);
        usi.saveUser("Elena", "Petrova", (byte) 19);
        System.out.println(usi.getAllUsers());
        usi.cleanUsersTable();
        usi.dropUsersTable();

    }
}
