package edu.hogwarts.ui;

public class MenuHandler {
    private final String horizontalLine = "----------------------------------------";

    public void showMainMenu() {
        System.out.println(horizontalLine);
        System.out.println("Main Menu");
        System.out.println("1. Students");
        System.out.println("2. Teachers");
        System.out.println("3. Show Students and Teachers");
        System.out.println("0. Exit");
        System.out.println(horizontalLine);
    }

    public void showStudentMenu() {
        System.out.println(horizontalLine);
        System.out.println("Student Menu");
        System.out.println("1. Add Student");
        System.out.println("2. Edit Student");
        System.out.println("3. Remove Student");
        System.out.println("4. Show Students");
        System.out.println("0. Back");
        System.out.println(horizontalLine);
    }

    public void showTeacherMenu() {
        System.out.println(horizontalLine);
        System.out.println("Teacher Menu");
        System.out.println("1. Add Teacher");
        System.out.println("2. Edit Teacher");
        System.out.println("3. Remove Teacher");
        System.out.println("4. Show Teachers");
        System.out.println("0. Back");
        System.out.println(horizontalLine);
    }

    public void showSortOrFilterMenu() {
        System.out.println(horizontalLine);
        System.out.println("Sort or Filter Menu");
        System.out.println("1. Sort");
        System.out.println("2. Filter");
        System.out.println("0. Back");
        System.out.println(horizontalLine);
    }

    public void showSortMenu() {
        System.out.println(horizontalLine);
        System.out.println("Sort by:");
        System.out.println("1. First name");
        System.out.println("2. Middle name");
        System.out.println("3. Last name");
        System.out.println("4. Age");
        System.out.println("5. House");
        System.out.println("6. Role");
        System.out.println("0. Back");
        System.out.println(horizontalLine);
    }

    public void showSortDirectionMenu() {
        System.out.println(horizontalLine);
        System.out.println("Sort direction:");
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        System.out.println("0. Back");
        System.out.println(horizontalLine);
    }

    public void showFilterMenu() {
        System.out.println(horizontalLine);
        System.out.println("Filter by:");
        System.out.println("1. House");
        System.out.println("2. Role");
        System.out.println("0. Back");
        System.out.println(horizontalLine);
    }

    public void showFilterMenu(String role) {
        System.out.println(horizontalLine);
        System.out.println("Filter " + role + "s by:");
        System.out.println("1. House");
        System.out.println("0. Back");
        System.out.println(horizontalLine);
    }

    public void showFilterByHouseMenu() {
        System.out.println(horizontalLine);
        System.out.println("Filter by house:");
        System.out.println("1. Gryffindor");
        System.out.println("2. Hufflepuff");
        System.out.println("3. Ravenclaw");
        System.out.println("4. Slytherin");
        System.out.println("0. Back");
        System.out.println(horizontalLine);
    }

    public void showFilterByRoleMenu() {
        System.out.println(horizontalLine);
        System.out.println("Filter by role:");
        System.out.println("1. Student");
        System.out.println("2. Teacher");
        System.out.println("0. Back");
        System.out.println(horizontalLine);
    }
}
