package edu.hogwarts.application;

import edu.hogwarts.controller.StudentController;
import edu.hogwarts.controller.TeacherController;
import edu.hogwarts.model.HogwartsStudent;
import edu.hogwarts.model.HogwartsTeacher;
import edu.hogwarts.model.House;
import edu.hogwarts.model.EmpType;

import java.time.LocalDate;
import java.time.Month;

public class InitData {
    private final StudentController studentController;
    private final TeacherController teacherController;

    public InitData(StudentController studentController, TeacherController teacherController) {
        this.studentController = studentController;
        this.teacherController = teacherController;
    }

    public void initData() {
        createStudents();
        createTeachers();
    }

    private void createStudents() {
        // === create hogwarts students ===
        var harry = new HogwartsStudent("Harry James Potter", LocalDate.of(1980, Month.JULY, 31), 1991, 1998, true, House.getGryffindor(), false, new String[]{"gryffindor quidditch team"});
        var hermione = new HogwartsStudent("Hermione Jean Granger", LocalDate.of(1979, Month.SEPTEMBER, 19), 1991, 1998, true, House.getGryffindor(), false);
        var ron = new HogwartsStudent("Ronald Bilius Weasley", LocalDate.of(1980, Month.MARCH, 1), 1991, 1998, true, House.getGryffindor(), false, new String[]{"gryffindor quidditch team"});
        var draco = new HogwartsStudent("Draco Lucius Malfoy", LocalDate.of(1980, Month.JUNE, 5), 1991, 1998, true, House.getSlytherin(), false, new String[]{"slytherin quidditch team"});
        var pansy = new HogwartsStudent("Pansy Parkinson", LocalDate.of(1980, Month.JULY, 4), 1991, 1998, true, House.getSlytherin(), false);
        var vincent = new HogwartsStudent("Vincent Crabbe", LocalDate.of(1980, Month.JANUARY, 1), 1991, 1998, true, House.getSlytherin(), false);
        var padma = new HogwartsStudent("Padma Patil", LocalDate.of(1980, Month.APRIL, 1), 1991, 1998, true, House.getRavenclaw(), false);
        var terry = new HogwartsStudent("Terry Boot", LocalDate.of(1980, Month.MAY, 1), 1991, 1998, true, House.getRavenclaw(), false);
        var michael = new HogwartsStudent("Michael Corner", LocalDate.of(1980, Month.JUNE, 1), 1991, 1998, true, House.getRavenclaw(), false);
        var justin = new HogwartsStudent("Justin Finch-Fletchley", LocalDate.of(1980, Month.JULY, 1), 1991, 1998, true, House.getHufflepuff(), false);
        var hannah = new HogwartsStudent("Hannah Abbott", LocalDate.of(1980, Month.AUGUST, 1), 1991, 1998, true, House.getHufflepuff(), false);
        var susan = new HogwartsStudent("Susan Bones", LocalDate.of(1980, Month.SEPTEMBER, 1), 1991, 1998, true, House.getHufflepuff(), false);

        var students = new HogwartsStudent[]{harry, hermione, ron, draco, pansy, vincent, padma, terry, michael, justin, hannah, susan};
        studentController.createStudent(students);
    }

    private void createTeachers() {
        // create hogwarts teachers
        var horace = new HogwartsTeacher("Horace Eugenia Slughorn", LocalDate.of(1882, Month.APRIL, 28), EmpType.TEACHER, LocalDate.of(1996, 9, 1), LocalDate.of(1997, 6, 30), House.getSlytherin(), false);
        var severus = new HogwartsTeacher("Severus Snape", LocalDate.of(1960, Month.JANUARY, 9), EmpType.TEACHER, LocalDate.of(1981, 9, 1), LocalDate.of(1997, 6, 30), House.getSlytherin(), true);
        var minerva = new HogwartsTeacher("Minerva McGonagall", LocalDate.of(1935, Month.OCTOBER, 4), EmpType.TEACHER, LocalDate.of(1956, 9, 1), LocalDate.of(1997, 6, 30), House.getGryffindor(), true);
        var filius = new HogwartsTeacher("Filius Flitwick", LocalDate.of(1935, Month.OCTOBER, 17), EmpType.TEACHER, LocalDate.of(1975, 9, 1), LocalDate.of(1997, 6, 30), House.getRavenclaw(), true);
        var pomona = new HogwartsTeacher("Pomona Sprout", LocalDate.of(1931, Month.MAY, 15), EmpType.TEACHER, LocalDate.of(1975, 9, 1), LocalDate.of(1997, 6, 30), House.getHufflepuff(), true);
        var alastor = new HogwartsTeacher("Alastor Moody", LocalDate.of(1960, Month.JANUARY, 1), EmpType.TEACHER, LocalDate.of(1994, 9, 1), LocalDate.of(1997, 6, 30), House.getGryffindor(), false);
        var remus = new HogwartsTeacher("Remus Lupin", LocalDate.of(1960, Month.MARCH, 10), EmpType.TEACHER, LocalDate.of(1993, 9, 1), LocalDate.of(1997, 6, 30), House.getGryffindor(), false);
        var dumbeldore = new HogwartsTeacher("Albus Percival Wulfric Brian Dumbledore", LocalDate.of(1881, Month.AUGUST, 1), EmpType.HEADMASTER, LocalDate.of(1938, 9, 1), LocalDate.of(1997, 6, 30), House.getGryffindor(), false);

        var teachers = new HogwartsTeacher[]{horace, severus, minerva, filius, pomona, alastor, remus, dumbeldore};
        teacherController.createTeacher(teachers);
    }

}
