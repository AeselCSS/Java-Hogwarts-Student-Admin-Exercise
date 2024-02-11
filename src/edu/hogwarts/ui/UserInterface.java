package edu.hogwarts.ui;

import edu.hogwarts.controller.StudentController;
import edu.hogwarts.controller.TeacherController;
import edu.hogwarts.model.HogwartsPerson;
import edu.hogwarts.model.HogwartsStudent;
import edu.hogwarts.model.HogwartsTeacher;

import java.util.ArrayList;
import java.util.List;

public class UserInterface {
    private final StudentController studentController;
    private final TeacherController teachersController;
    private final MenuHandler menuHandler;
    private final InputHandler inputHandler;
    private final SortAndFilterHandler sortAndFilterHandler;
    private final StudentHandler studentHandler;
    private final TeacherHandler teacherHandler;
    private final Utility utility;

    public UserInterface(StudentController studentController, TeacherController teachersController) {
        this.studentController = studentController;
        this.teachersController = teachersController;
        this.menuHandler = new MenuHandler();
        this.inputHandler = new InputHandler();
        this.sortAndFilterHandler = new SortAndFilterHandler();
        this.studentHandler = new StudentHandler(studentController);
        this.teacherHandler = new TeacherHandler(teachersController);
        this.utility = new Utility();
    }

    public void initUI() {
        System.out.println("Welcome to Hogwarts School of Witchcraft and Wizardry");
        boolean exit = false;

        while (!exit) {
            menuHandler.showMainMenu();
            int choice = inputHandler.getChoice();
            switch (choice) {
                case 1 -> studentHandler.handleStudentMenu();
                case 2 -> teacherHandler.handleTeacherMenu();
                case 3 -> handleSortAndFilterOptions();
                case 0 -> exit = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void handleSortAndFilterOptions() {
        boolean back = false;
        while (!back) {
            menuHandler.showSortOrFilterMenu();
            int choice = inputHandler.getChoice();
            switch (choice) {
                case 1 -> handleSortOptions();
                case 2 -> handleFilterOptions();
                case 0 -> back = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void handleSortOptions() {
        boolean back = false;
        while (!back) {
            menuHandler.showSortMenu();
            int choice = inputHandler.getChoice();
            switch (choice) {
                case 1 -> handleSortDirectionOptions(SortByOption.FIRST_NAME);
                case 2 -> handleSortDirectionOptions(SortByOption.MIDDLE_NAME);
                case 3 -> handleSortDirectionOptions(SortByOption.LAST_NAME);
                case 4 -> handleSortDirectionOptions(SortByOption.AGE);
                case 5 -> handleSortDirectionOptions(SortByOption.HOUSE);
                case 6 -> handleSortDirectionOptions(SortByOption.ROLE);
                case 0 -> back = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void handleSortDirectionOptions(SortByOption sortByOption) {
        boolean back = false;
        while (!back) {
            menuHandler.showSortDirectionMenu();
            int choice = inputHandler.getChoice();
            switch (choice) {
                case 1 -> utility.handleSort(CombineAllStudentsAndTeachers(), sortByOption, SortDirectionOption.ASCENDING);
                case 2 -> utility.handleSort(CombineAllStudentsAndTeachers(), sortByOption, SortDirectionOption.DESCENDING);
                case 0 -> back = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void handleFilterOptions() {
        boolean back = false;
        while (!back) {
            menuHandler.showFilterMenu();
            int choice = inputHandler.getChoice();
            switch (choice) {
                case 1 -> handleFilterByHouse();
                case 2 -> handleFilterByRole();
                case 0 -> back = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void handleFilterByRole() {
        boolean back = false;
        while (!back) {
            menuHandler.showFilterByRoleMenu();
            int choice = inputHandler.getChoice();
            switch (choice) {
                case 1 -> utility.printTable(sortAndFilterHandler.filterByRole(CombineAllStudentsAndTeachers(), FilterByRoleOption.STUDENT));
                case 2 -> utility.printTable(sortAndFilterHandler.filterByRole(CombineAllStudentsAndTeachers(), FilterByRoleOption.TEACHER));
                case 0 -> back = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void handleFilterByHouse() {
        boolean back = false;
        while (!back) {
            menuHandler.showFilterByHouseMenu();
            int choice = inputHandler.getChoice();
            switch (choice) {
                case 1 -> utility.printTable(sortAndFilterHandler.filterByHouse(CombineAllStudentsAndTeachers(), FilterByHouseOption.GRYFFINDOR));
                case 2 -> utility.printTable(sortAndFilterHandler.filterByHouse(CombineAllStudentsAndTeachers(), FilterByHouseOption.HUFFLEPUFF));
                case 3 -> utility.printTable(sortAndFilterHandler.filterByHouse(CombineAllStudentsAndTeachers(), FilterByHouseOption.RAVENCLAW));
                case 4 -> utility.printTable(sortAndFilterHandler.filterByHouse(CombineAllStudentsAndTeachers(), FilterByHouseOption.SLYTHERIN));
                case 0 -> back = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private ArrayList<HogwartsPerson> CombineAllStudentsAndTeachers() {
        ArrayList<HogwartsPerson> allPeople = new ArrayList<>();

        List<HogwartsStudent> allStudents = studentController.readAllStudents();
        List<HogwartsTeacher> allTeachers = teachersController.readAllTeachers();

        // combine Lists
        allPeople.addAll(allStudents);
        allPeople.addAll(allTeachers);

        return allPeople;
    }


}




