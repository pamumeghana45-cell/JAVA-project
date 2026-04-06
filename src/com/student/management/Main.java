package com.student.management;

import java.util.*;
import java.io.*;
import com.student.module.StudentModule;
import com.student.model.Student;

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static final String FILE_NAME = "students.txt";
    static final String ADMIN_PASSWORD = "admin123";

    public static void main(String[] args) {

        loadData();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== LOGIN MENU =====");
            System.out.println("1. Admin");
            System.out.println("2. Student");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    adminLogin(sc);
                    break;

                case 2:
                    StudentModule.showStudentMenu(sc, students);
                    break;

                case 3:
                    System.out.println("Exiting Application...");
                    return;

                default:
                    System.out.println("Invalid Choice ❌");
            }
        }
    }

    // ================= ADMIN LOGIN =================

    static void adminLogin(Scanner sc) {

        sc.nextLine(); // clear buffer

        System.out.print("Enter Admin Password: ");
        String pass = sc.nextLine();

        if (pass.equals(ADMIN_PASSWORD)) {
            System.out.println("Login Successful ✔");
            showAdminMenu(sc);
        } else {
            System.out.println("Invalid Password ❌");
        }
    }

    // ================= ADMIN MENU =================

    static void showAdminMenu(Scanner sc) {

        while (true) {

            System.out.println("\n===== ADMIN MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Save Data");
            System.out.println("6. Logout");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent(sc);
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent(sc);
                    break;

                case 4:
                    deleteStudent(sc);
                    break;

                case 5:
                    saveData();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid Choice ❌");
            }
        }
    }

    static void addStudent(Scanner sc) {

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getRoll() == roll) {
                System.out.println("Roll Number already exists ❌");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Set Password: ");
        String password = sc.nextLine();

        System.out.print("Enter Marks 1: ");
        double m1 = sc.nextDouble();

        System.out.print("Enter Marks 2: ");
        double m2 = sc.nextDouble();

        System.out.print("Enter Marks 3: ");
        double m3 = sc.nextDouble();

        students.add(new Student(roll, name, password, m1, m2, m3));
        System.out.println("Student Added Successfully ✔");
    }

    static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Found ❌");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    static void searchStudent(Scanner sc) {

        System.out.print("Enter Roll to Search: ");
        int roll = sc.nextInt();

        for (Student s : students) {
            if (s.getRoll() == roll) {
                s.display();
                return;
            }
        }

        System.out.println("Student Not Found ❌");
    }

    static void deleteStudent(Scanner sc) {

        System.out.print("Enter Roll to Delete: ");
        int roll = sc.nextInt();

        boolean removed = students.removeIf(s -> s.getRoll() == roll);

        if (removed)
            System.out.println("Student Deleted ✔");
        else
            System.out.println("Student Not Found ❌");
    }

    static void saveData() {

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME));

            for (Student s : students) {
                pw.println(s.toFileString());
            }

            pw.close();
            System.out.println("Data Saved Successfully ✔");

        } catch (Exception e) {
            System.out.println("Error Saving Data ❌");
        }
    }

    static void loadData() {

        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) return;

            Scanner fs = new Scanner(file);

            while (fs.hasNextLine()) {

                String line = fs.nextLine();
                String[] data = line.split(",");

                int roll = Integer.parseInt(data[0]);
                String name = data[1];
                String password = data[2];
                double m1 = Double.parseDouble(data[3]);
                double m2 = Double.parseDouble(data[4]);
                double m3 = Double.parseDouble(data[5]);

                students.add(new Student(roll, name, password, m1, m2, m3));
            }

            fs.close();
            System.out.println("Data Loaded Successfully ✔");

        } catch (Exception e) {
            System.out.println("Error Loading Data ❌");
        }
    }
}