package edu.hogwarts;

import java.time.LocalDate;

public class YearGroup {
    private int schoolYear;
    private LocalDate beginningOfSchoolYear;
    private Student[] students;

    public YearGroup(int schoolYear, LocalDate beginningOfSchoolYear, Student[] students) {
        this.schoolYear = schoolYear;
        this.beginningOfSchoolYear = beginningOfSchoolYear;
        this.students = students;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

    public LocalDate getBeginningOfSchoolYear() {
        return beginningOfSchoolYear;
    }

    public void setBeginningOfSchoolYear(LocalDate beginningOfSchoolYear) {
        this.beginningOfSchoolYear = beginningOfSchoolYear;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    @Override
    public String toString() {
        StringBuilder studensToString = new StringBuilder();
        for (Student student : students) {
            studensToString.append(student.getFullName()).append(", ");
        }

        return "YearGroup {\n" +
                "schoolYear=" + schoolYear + "\n" +
                ", beginningOfSchoolYear=" + beginningOfSchoolYear + "\n" +
                ", students=" + studensToString + "\n" +
                '}';
    }
}