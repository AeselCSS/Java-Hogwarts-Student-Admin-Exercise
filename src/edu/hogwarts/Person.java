package edu.hogwarts;

public class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;

    public Person() {
    }

    public Person(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName) {
        this(firstName, null, lastName);
    }

    public Person(String fullName) {
        setFullName(fullName);
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return middleName != null ? firstName + " " + middleName + " " + lastName : firstName + " " + lastName;
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
        String twoNames = this.firstName + " " + this.lastName + ", Age: " + this.age;
        String moreThanTwoNames = this.firstName + " " + this.middleName + " " + this.lastName + ", Age: " + this.age;

        return hasMiddleName() ? moreThanTwoNames : twoNames;
    }
}