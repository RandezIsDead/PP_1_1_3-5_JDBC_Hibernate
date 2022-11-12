package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    public static void main(String[] args) {
        UserServiceImpl service = new UserServiceImpl();
        service.createUsersTable();
        service.saveUser("Johny", "Silverhand", (byte) 34);
        service.saveUser("Bonnie", "Parker", (byte) 23);
        service.saveUser("Clyde", "Barrow", (byte) 25);
        service.saveUser("Keanu", "Reeves", (byte) 58);
        for (User user : service.getAllUsers()) {
            System.out.println(user.toString());
        }
        service.cleanUsersTable();
        service.dropUsersTable();
    }
}
