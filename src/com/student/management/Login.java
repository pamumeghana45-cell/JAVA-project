package com.student.management;

import java.util.Scanner;

public class Login {

    static User[] users = {
            new User("admin", "admin123", "ADMIN"),
            new User("student", "stud123", "STUDENT")
    };

    static User authenticate() {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== LOGIN =====");
        System.out.print("Username: ");
        String uname = sc.nextLine();

        System.out.print("Password: ");
        String pass = sc.nextLine();

        for (User u : users) {
            if (u.username.equals(uname) && u.password.equals(pass)) {
                System.out.println("Login Successful ✔");
                return u;
            }
        }

        System.out.println("Invalid Credentials ❌");
        return null;
    }
}