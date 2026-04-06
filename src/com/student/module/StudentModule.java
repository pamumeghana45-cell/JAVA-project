package com.student.module;

import java.util.ArrayList;
import java.util.Scanner;
import com.student.management.Student;

public class StudentModule {

    public static void showStudentMenu(Scanner sc,
                                       ArrayList<Student> students) {

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        Student loggedInStudent = null;

        for (Student s : students) {
            if (s.getRoll() == roll &&
                s.getPassword().equals(password)) {
                loggedInStudent = s;
                break;
            }
        }

        if (loggedInStudent == null) {
            System.out.println("Invalid Credentials ❌");
            return;
        }

        while (true) {

            System.out.println("\n===== STUDENT MENU =====");
            System.out.println("1. View My Result");
            System.out.println("2. Logout");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    loggedInStudent.display();
                    break;

                case 2:
                    System.out.println("Logging out...");
                    return;

                default:
                    System.out.println("Invalid Choice ❌");
            }
        }
    }
}