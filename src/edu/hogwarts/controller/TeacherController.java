package edu.hogwarts.controller;

import edu.hogwarts.model.HogwartsTeacher;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class TeacherController {
    // create collection to store teachers
    private final HashMap<UUID, HogwartsTeacher> teachers = new HashMap<>();

    // constructors
    public TeacherController() {
        super();
    }

    // CRUD operations for teachers
    public void createTeacher(HogwartsTeacher teacher) {
        teachers.put(teacher.getId(), teacher);
    }

    public void createTeacher(HogwartsTeacher... teachers) {
        for (HogwartsTeacher teacher : teachers) {
            createTeacher(teacher);
        }
    }

    public HogwartsTeacher readTeacher(UUID id) {
        return teachers.get(id);
    }

    public List<HogwartsTeacher> readAllTeachers() {
        return teachers.values().stream().toList();
    }

    public void updateTeacher(HogwartsTeacher teacher) {
        teachers.put(teacher.getId(), teacher);
    }

    public void deleteTeacher(UUID id) {
        teachers.remove(id);
    }

    @Override
    public String toString() {
        return "TeacherController {\n" +
                "teachers: " + teachers + "\n" +
                '}';
    }
}
