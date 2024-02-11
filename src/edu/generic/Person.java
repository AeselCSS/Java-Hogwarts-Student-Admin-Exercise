package edu.generic;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;
    private final UUID id;

    public Person() {
        this.id = UUID.randomUUID();
    }

    public Person(String firstName, String middleName, String lastName, LocalDate dateOfBirth) {
        this();
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        setDateOfBirth(dateOfBirth);
    }

    public Person(String firstName, String lastName, LocalDate dateOfBirth) {
        this();
        setFirstName(firstName);
        setMiddleName(null);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
    }

    public Person(String fullName, LocalDate dateOfBirth) {
        this();
        setFullName(fullName);
        setDateOfBirth(dateOfBirth);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        // Validate date of birth
        if (dateOfBirth.isAfter(LocalDate.now()) || dateOfBirth.isEqual(LocalDate.now())) {
            throw new IllegalArgumentException("Date of birth cannot be in the future");
        } else {
            this.dateOfBirth = dateOfBirth;
        }
    }

    public UUID getId() {
        return id;
    }

    public Integer getAge() {
        LocalDate now = LocalDate.now().withYear(1992);
        return Period.between(getDateOfBirth(), now).getYears();
    }

    public String getFullName() {
        return middleName != null ? getFirstName() + " " + getMiddleName() + " " + getLastName() : getFirstName() + " " + getLastName();
    }

    public void setFullName(String fullName) {
        int firstSpace = fullName.indexOf(" ");
        int lastSpace = fullName.lastIndexOf(" ");

        this.firstName = fullName.substring(0, firstSpace);
        this.middleName = firstSpace != lastSpace ? fullName.substring(firstSpace + 1, lastSpace) : null;
        this.lastName = fullName.substring(lastSpace + 1);
    }

    public boolean hasMiddleName() {
        return this.middleName != null;
    }

    @Override
    public String toString() {
        String twoNames = getFirstName() + " " + getLastName() + ", Age: " + getAge() + ", ID: " + getId();
        String moreThanTwoNames = getFirstName() + " " + getMiddleName() + " " + getLastName() + ", Age: " + getAge() + ", ID: " + getId();

        return hasMiddleName() ? moreThanTwoNames : twoNames;
    }
}