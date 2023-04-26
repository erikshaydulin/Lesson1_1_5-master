package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl usi = new UserServiceImpl();
        usi.createUsersTable();
        usi.saveUser("Nikita", "Salomandrov", (byte) 25);
        usi.saveUser("Zaur", "Tregulov", (byte) 29);
        usi.saveUser("Erik", "Shaydulin", (byte) 31);
        usi.saveUser("Elena", "Petrova", (byte) 19);
        System.out.println(usi.getAllUsers());
        System.out.println("Теперь будем решать через Hibernate");
        usi.cleanUsersTable();
        usi.dropUsersTable();

    }
}
