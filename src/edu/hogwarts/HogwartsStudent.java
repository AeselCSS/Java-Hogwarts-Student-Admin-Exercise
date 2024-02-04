package edu.hogwarts;

public class HogwartsStudent extends Student implements HogwartsPerson {
    private House house;
    private boolean prefect;
    private String[] teams;

    public HogwartsStudent(String fullName, int enrollmentYear, int graduationYear, Boolean graduated, House house, boolean prefect, String[] teams) {
        super(fullName, enrollmentYear, graduationYear, graduated);
        this.house = house;
        this.prefect = prefect;
        this.teams = teams;
    }

    public HogwartsStudent(String fullName, int enrollmentYear, int graduationYear, Boolean graduated, House house, boolean prefect) {
        super(fullName, enrollmentYear, graduationYear, graduated);
        this.house = house;
        this.prefect = prefect;
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
                "fullName=" + getFullName() + "\n" +
                ", enrollmentYear=" + getEnrollmentYear() + "\n" +
                ", graduationYear=" + getGraduationYear() + "\n" +
                ", graduated=" + getGraduated() + "\n" +
                ", house=" + house + "\n" +
                ", prefect=" + prefect + "\n" +
                ", teams=" + teams + "\n" +
                '}';
    }
}
