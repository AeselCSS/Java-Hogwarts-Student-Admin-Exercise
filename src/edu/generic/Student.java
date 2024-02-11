package edu.generic;

import java.time.LocalDate;

public class Student extends Person {
    private int enrollmentYear;
    private int graduationYear;
    private Boolean graduated;

    public Student() {
        super();
    }

    public Student(int enrollmentYear, int graduationYear, Boolean graduated) {
        this.enrollmentYear = enrollmentYear;
        this.graduationYear = graduationYear;
        this.graduated = graduated;
    }

    public Student(String fullName, LocalDate dateOfBirth, int enrollmentYear, int graduationYear, Boolean graduated) {
        super(fullName, dateOfBirth);
        this.enrollmentYear = enrollmentYear;
        this.graduationYear = graduationYear;
        this.graduated = graduated;
    }


    public Student(String firstName, String middleName, String lastName, LocalDate dateOfBirth, int enrollmentYear, int graduationYear, Boolean graduated) {
        super(firstName, middleName, lastName, dateOfBirth);
        this.enrollmentYear = enrollmentYear;
        this.graduationYear = graduationYear;
        this.graduated = graduated;
    }

    public Student(String firstName, String lastName, LocalDate dateOfBirth, int enrollmentYear, int graduationYear, Boolean graduated) {
        super(firstName, lastName, dateOfBirth);
        this.enrollmentYear = enrollmentYear;
        this.graduationYear = graduationYear;
        this.graduated = graduated;
    }

    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(int enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    public Boolean getGraduated() {
        return graduated;
    }

    public void setGraduated(Boolean graduated) {
        this.graduated = graduated;
    }

    @Override
    public String toString() {
        return "Student {\n" +
                "id=" + getId() + "\n" +
                "fullName=" + getFullName() + "\n" +
                "enrollmentYear=" + enrollmentYear + "\n" +
                "graduationYear=" + graduationYear + "\n" +
                "graduated=" + graduated + "\n" +
                '}';
    }
}
