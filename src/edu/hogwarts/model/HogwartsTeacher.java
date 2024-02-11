package edu.hogwarts.model;

import edu.generic.Teacher;

import java.time.LocalDate;

public class HogwartsTeacher extends Teacher implements HogwartsPerson {
    private House house;
    private boolean headOfHouse;

    public HogwartsTeacher(String fullName, LocalDate dateOfBirth, EmpType employment, LocalDate employmentStart, LocalDate employmentEnd, House house, boolean headOfHouse) {
        super(fullName, dateOfBirth, employment, employmentStart, employmentEnd);
        this.house = house;
        this.headOfHouse = headOfHouse;
    }

    public HogwartsTeacher() {
        super();
        this.house = new House();
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public boolean isHeadOfHouse() {
        return headOfHouse;
    }

    public void setHeadOfHouse(boolean headOfHouse) {
        this.headOfHouse = headOfHouse;
    }

    @Override
    public String toString() {
        return "HogwartsTeacher {\n" +
                "fullName=" + getFullName() + "\n" +
                ", employment=" + getEmployment() + "\n" +
                ", employmentStart=" + getEmploymentStart() + "\n" +
                ", employmentEnd=" + getEmploymentEnd() + "\n" +
                ", house=" + house + "\n" +
                ", headOfHouse=" + isHeadOfHouse() + "\n" +
                '}';
    }
}
