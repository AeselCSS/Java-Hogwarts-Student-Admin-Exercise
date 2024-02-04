package edu.hogwarts;

public class Course {
    private Subject subject;
    private Teacher teacher;
    private Student[] students;
    private TeachingMaterial[] materials;

    public Course(Subject subject, Teacher teacher, Student[] students, TeachingMaterial[] materials) {
        this.subject = subject;
        this.teacher = teacher;
        this.students = students;
        this.materials = materials;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public TeachingMaterial[] getMaterials() {
        return materials;
    }

    public void setMaterials(TeachingMaterial[] materials) {
        this.materials = materials;
    }

    @Override
    public String toString() {

        StringBuilder studensToString = new StringBuilder();
        for (Student student : students) {
            studensToString.append(student.getFullName()).append(", ");
        }

        StringBuilder materialsToString = new StringBuilder();
        for (TeachingMaterial material : materials) {
            materialsToString.append(material.getName()).append(", ");
        }

        return "Course {\n" +
                "Subject:" + subject.getName() + "\n" +
                "Teacher:" + teacher.getFullName() + "\n" +
                "Students enrolled:" + studensToString + "\n" +
                "Materials:" + materialsToString + "\n" +
                '}';
    }
}