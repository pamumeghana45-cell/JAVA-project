package com.student.management;

public class Student {

    private int roll;
    private String name;
    private String password;
    private double m1, m2, m3;

    public Student(int roll, String name, String password,
                   double m1, double m2, double m3) {
        this.roll = roll;
        this.name = name;
        this.password = password;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }

    public int getRoll() {
        return roll;
    }

    public String getPassword() {
        return password;
    }

    public double getTotal() {
        return m1 + m2 + m3;
    }

    public double getPercentage() {
        return getTotal() / 3;
    }

    public String getGrade() {
        double per = getPercentage();
        if (per >= 90) return "A+";
        else if (per >= 75) return "A";
        else if (per >= 60) return "B";
        else if (per >= 50) return "C";
        else return "Fail";
    }

    public void display() {
        System.out.println("=================================");
        System.out.println("Roll Number : " + roll);
        System.out.println("Name        : " + name);
        System.out.println("Marks 1     : " + m1);
        System.out.println("Marks 2     : " + m2);
        System.out.println("Marks 3     : " + m3);
        System.out.println("---------------------------------");
        System.out.println("Total       : " + getTotal());
        System.out.println("Percentage  : " + getPercentage() + "%");
        System.out.println("Grade       : " + getGrade());
        System.out.println("=================================");
    }

    public String toFileString() {
        return roll + "," + name + "," + password + ","
                + m1 + "," + m2 + "," + m3;
    }
}