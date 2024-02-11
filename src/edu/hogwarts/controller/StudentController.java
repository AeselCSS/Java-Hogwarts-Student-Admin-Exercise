package edu.hogwarts.controller;

import edu.hogwarts.model.HogwartsStudent;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class StudentController {
    // create a HashMap to store students by their UUID
    private final HashMap<UUID, HogwartsStudent> students = new HashMap<>();

    // constructor
    public StudentController() {
        super();
    }

    // CRUD operations for students
    public void createStudent(HogwartsStudent student) {
        students.put(student.getId(), student);
    }

    public void createStudent(HogwartsStudent... students) {
        for (HogwartsStudent student : students) {
            createStudent(student);
        }
    }

    public HogwartsStudent readStudent(UUID id) {
        return students.get(id);
    }

    public List<HogwartsStudent> readAllStudents() {
        return students.values().stream().toList();
    }

    public void updateStudent(HogwartsStudent student) {
        students.put(student.getId(), student);
    }

    public void deleteStudent(UUID id) {
        students.remove(id);
    }

    @Override
    public String toString() {
        return "StudentController {\n" +
                "students: " + students + "\n" +
                '}';
    }
}
