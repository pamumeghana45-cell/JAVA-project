package com.student.model;

public class Subject {
    private int subjectId;
    private String subjectName;
    private double marks;

    public Subject(int subjectId, String subjectName, double marks) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.marks = marks;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}