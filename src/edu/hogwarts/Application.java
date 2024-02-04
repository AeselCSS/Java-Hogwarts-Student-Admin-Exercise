package edu.hogwarts;

import java.time.LocalDate;
import java.util.ArrayList;

public class Application {
    // === create arrays ===
    House[] houses;
    HogwartsStudent[] students;
    HogwartsTeacher[] teachers;
    Subject[] subjects;
    Course[] courses;
    TeachingMaterial[] teachingMaterials;

    public void initApp() {
        // === create houses ===
        var gryffindor = new House("Gryffindor", "Godric Gryffindor", "scarlet", "gold");
        var hufflepuff = new House("Hufflepuff", "Helga Hufflepuff", "yellow", "black");
        var ravenclaw = new House("Ravenclaw", "Rowena Ravenclaw", "blue", "silver");
        var slytherin = new House("Slytherin", "Salazar Slytherin", "green", "silver");

        // === add houses to houses array ===
        houses = new House[]{gryffindor, hufflepuff, ravenclaw, slytherin};

        // === create hogwarts students ===
        var harry = new HogwartsStudent("Harry James Potter", 1991, 1998, true, gryffindor, false, new String[]{"gryffindor quidditch team"});
        var hermione = new HogwartsStudent("Hermione Jean Granger", 1991, 1998, true, gryffindor, false);
        var ron = new HogwartsStudent("Ronald Bilius Weasley", 1991, 1998, true, gryffindor, false, new String[]{"gryffindor quidditch team"});
        var draco = new HogwartsStudent("Draco Lucius Malfoy", 1991, 1998, true, slytherin, false, new String[]{"slytherin quidditch team"});
        var pansy = new HogwartsStudent("Pansy Parkinson", 1991, 1998, true, slytherin, false);
        var vincent = new HogwartsStudent("Vincent Crabbe", 1991, 1998, true, slytherin, false);
        var padma = new HogwartsStudent("Padma Patil", 1991, 1998, true, ravenclaw, false);
        var terry = new HogwartsStudent("Terry Boot", 1991, 1998, true, ravenclaw, false);
        var michael = new HogwartsStudent("Michael Corner", 1991, 1998, true, ravenclaw, false);
        var justin = new HogwartsStudent("Justin Finch-Fletchley", 1991, 1998, true, hufflepuff, false);
        var hannah = new HogwartsStudent("Hannah Abbott", 1991, 1998, true, hufflepuff, false);
        var susan = new HogwartsStudent("Susan Bones", 1991, 1998, true, hufflepuff, false);

        // === add students to students array ===
        students = new HogwartsStudent[]{harry, hermione, ron, draco, pansy, vincent, padma, terry, michael, justin, hannah, susan};

        // === create hogwarts teachers ===
        var horace = new HogwartsTeacher("Horace Eugenia Slughorn", empType.TEACHER, LocalDate.of(1996, 9, 1), LocalDate.of(1997, 6, 30), slytherin, false);
        var severus = new HogwartsTeacher("Severus Snape", empType.TEACHER, LocalDate.of(1981, 9, 1), LocalDate.of(1997, 6, 30), slytherin, true);

        // === add teachers to teachers array ===
        teachers = new HogwartsTeacher[]{horace, severus};

        // === create subjects ===
        var potions = new Subject("Potions", 6, false);

        // === add subjects to subjects array ===
        subjects = new Subject[]{potions};

        // === create teaching materials ===
        var potionBook = new TextBook("Advanced Potion-Making", true,true, false, "TextBook","Advanced Potion-Making", "Libatius Borage", "Merge Books", 1999);
        var wand = new Wand("Wand", false, true, false, "Vine wood with a Dragon Heartstring core. Known for its flexibility.",10.75, "Vine", "Dragon Heartstring");
        var cauldron = new Tool("Cauldron", false, true, false, "Pewter", "Standard size 2");
        var silverKnife = new Tool("Silver Knife", false, true, false, "Silver", "Standard size");
        var newtSpleens = new Ingredient("Newt Spleens", true, true, false, "Newt Spleens", 13.00, "ounces");
        var peppermint = new Ingredient("Peppermint", true, true, false, "Peppermint", 8.50, "ounce");
        var slothBrain = new Ingredient("Sloth Brain", true, true, false, "Sloth Brain", 2.25, "ounce");
        var bezoar = new Ingredient("Bezoar", true, true, false, "Bezoar", 1.00, "ounce");
        var billywigWings = new Ingredient("Billywig Wings", true, true, false, "Billywig Wings", 7.75, "ounce");
        var infusionOfWormwood = new Ingredient("Infusion of Wormwood", true, true, false, "Infusion of Wormwood", 11.25, "ounce");

        // === add teaching materials to teachingMaterials array ===
        teachingMaterials = new TeachingMaterial[]{potionBook, wand, cauldron, silverKnife, newtSpleens, peppermint, slothBrain, bezoar, billywigWings, infusionOfWormwood};

        // === create courses ===
        var potionsCourse = new Course(potions, horace, students, teachingMaterials);

        // === add courses to courses array ===
        courses = new Course[]{potionsCourse};

        // === print out the courses ===
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.initApp();
    }
}
