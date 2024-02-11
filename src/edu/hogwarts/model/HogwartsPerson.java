package edu.hogwarts.model;

import java.util.UUID;

public interface HogwartsPerson {
    String getFirstName();

    String getMiddleName();

    String getLastName();

    Integer getAge();

    House getHouse();

    void setHouse(House house);


}
