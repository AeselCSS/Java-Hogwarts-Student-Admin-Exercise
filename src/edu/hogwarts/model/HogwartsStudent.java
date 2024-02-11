package edu.hogwarts.model;

import edu.generic.Student;

import java.time.LocalDate;
import java.util.Arrays;

public class HogwartsStudent extends Student implements HogwartsPerson {
    private House house;
    private boolean prefect;
    private String[] teams;

    public HogwartsStudent(String fullName, LocalDate dateOfBirth, int enrollmentYear, int graduationYear, Boolean graduated, House house, boolean prefect, String[] teams) {
        super(fullName, dateOfBirth, enrollmentYear, graduationYear, graduated);
        this.house = house;
        this.prefect = prefect;
        this.teams = teams;
    }

    public HogwartsStudent(String fullName, LocalDate dateOfBirth, int enrollmentYear, int graduationYear, Boolean graduated, House house, boolean prefect) {
        super(fullName, dateOfBirth, enrollmentYear, graduationYear, graduated);
        this.house = house;
        this.prefect = prefect;
    }

    public HogwartsStudent() {
        super();
        this.house = new House();
        this.prefect = false;
        this.teams = new String[0];
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public boolean isPrefect() {
        return prefect;
    }

    public void setPrefect(boolean prefect) {
        this.prefect = prefect;
    }

    public String[] getTeams() {
        return teams;
    }

    public void setTeams(String[] teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "HogwartsStudent {\n" +
                "id=" + getId() + "\n" +
                "fullName=" + getFullName() + "\n" +
                "enrollmentYear=" + getEnrollmentYear() + "\n" +
                "graduationYear=" + getGraduationYear() + "\n" +
                "graduated=" + getGraduated() + "\n" +
                "house=" + house + "\n" +
                "prefect=" + isPrefect() + "\n" +
                "teams=" + Arrays.toString(getTeams()) + "\n" +
                '}' + "\n" +
                "---------------------------------------_" + "\n";
    }
}
