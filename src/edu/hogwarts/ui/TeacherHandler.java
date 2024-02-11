package edu.hogwarts.ui;

import edu.generic.Teacher;
import edu.hogwarts.controller.TeacherController;
import edu.hogwarts.model.HogwartsPerson;
import edu.hogwarts.model.HogwartsTeacher;
import edu.hogwarts.model.House;
import edu.hogwarts.model.EmpType;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class TeacherHandler {
    private final TeacherController teachersController;
    private final MenuHandler menuHandler;
    private final InputHandler inputHandler;
    private final SortAndFilterHandler sortAndFilterHandler;
    private final Utility utility;

    public TeacherHandler(@NotNull TeacherController teachersController) {
        this.teachersController = teachersController;
        this.menuHandler = new MenuHandler();
        this.inputHandler = new InputHandler();
        this.sortAndFilterHandler = new SortAndFilterHandler();
        this.utility = new Utility();
    }

    // === Teacher Menu ===
    public void handleTeacherMenu() {
        boolean back = false;
        while (!back) {
            menuHandler.showTeacherMenu();
            int choice = inputHandler.getChoice();
            switch (choice) {
                case 1 -> addTeacher();
                case 2 -> editTeacher();
                case 3 -> deleteTeacher();
                case 4 -> handleSortOrFilterTeachers();
                case 0 -> back = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addTeacher() {
        HogwartsTeacher teacher = new HogwartsTeacher();
        // name
        String fullName = inputHandler.getStringInput("Enter full name:");
        teacher.setFullName(fullName);
        // date of birth
        LocalDate dateOfBirth = inputHandler.getDateInput("Enter date of birth (yyyy-mm-dd):");
        teacher.setDateOfBirth(dateOfBirth);
        // employment type
        EmpType employment = inputHandler.getEmpTypeInput();
        teacher.setEmployment(employment);
        // employment start date
        LocalDate employmentStart = inputHandler.getDateInput("Enter hire date (yyyy-mm-dd):");
        teacher.setEmploymentStart(employmentStart);
        // employment end date
        LocalDate employmentEnd = inputHandler.getDateInput("Enter end date (yyyy-mm-dd):");
        teacher.setEmploymentEnd(employmentEnd);
        // house
        House house = inputHandler.getHouseInput();
        teacher.setHouse(house);
        // head of house
        boolean headOfHouse = inputHandler.getBooleanInput("Is the teacher head of house?");
        teacher.setHeadOfHouse(headOfHouse);
        // add teacher
        teachersController.createTeacher(teacher);
    }

    private void editTeacher() {
        UUID id = inputHandler.getUUID();
        HogwartsTeacher teacher = teachersController.readTeacher(id);
        if (teacher != null) {
            // Prompt user for new details
            // name
            String newName = inputHandler.getStringInput("Enter new name:");
            teacher.setFullName(newName);
            // date of birth
            LocalDate newDob = inputHandler.getDateInput("Enter new date of birth (yyyy-mm-dd):");
            teacher.setDateOfBirth(newDob);
            // employment type
            EmpType newEmpType = inputHandler.getEmpTypeInput();
            teacher.setEmployment(newEmpType);
            // employment start date
            LocalDate newStartDate = inputHandler.getDateInput("Enter new hire date (yyyy-mm-dd):");
            teacher.setEmploymentStart(newStartDate);
            // employment end date
            LocalDate newEndDate = inputHandler.getDateInput("Enter new end date (yyyy-mm-dd):");
            teacher.setEmploymentEnd(newEndDate);
            // house
            House newHouse = inputHandler.getHouseInput();
            teacher.setHouse(newHouse);
            // head of house
            boolean newHeadOfHouse = inputHandler.getBooleanInput("Is the teacher head of house?");
            teacher.setHeadOfHouse(newHeadOfHouse);
            // update teacher
            teachersController.updateTeacher(teacher);
            System.out.println("Teacher updated successfully.");
        } else {
            System.out.println("Teacher not found.");
        }
    }

    private void deleteTeacher() {
        UUID id = inputHandler.getUUID();
        Teacher teacher = teachersController.readTeacher(id);
        if (teacher != null) {
            teachersController.deleteTeacher(id);
            System.out.println("Teacher deleted successfully.");
        } else {
            System.out.println("Teacher not found.");
        }
    }

    private void handleSortOrFilterTeachers() {
        boolean back = false;
        while (!back) {
            menuHandler.showSortOrFilterMenu();
            int choice = inputHandler.getChoice();
            switch (choice) {
                case 1 -> sortTeachers();
                case 2 -> filterTeachers();
                case 0 -> back = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void sortTeachers() {
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
        ArrayList<HogwartsPerson> students = new ArrayList<>(teachersController.readAllTeachers());

        boolean back = false;
        while (!back) {
            menuHandler.showSortDirectionMenu();
            int choice = inputHandler.getChoice();
            switch (choice) {
                case 1 -> utility.handleSort(students, sortByOption, SortDirectionOption.ASCENDING);
                case 2 -> utility.handleSort(students, sortByOption, SortDirectionOption.DESCENDING);
                case 0 -> back = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void filterTeachers() {
        boolean back = false;
        while (!back) {
            menuHandler.showFilterMenu("Student");
            int choice = inputHandler.getChoice();
            switch (choice) {
                case 1 -> filterByHouse();
                case 0 -> back = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void filterByHouse() {
        boolean back = false;
        while (!back) {
            menuHandler.showFilterByHouseMenu();
            int choice = inputHandler.getChoice();
            switch (choice) {
                case 1 ->
                        utility.printTable(sortAndFilterHandler.filterByHouse(new ArrayList<>(teachersController.readAllTeachers()), FilterByHouseOption.GRYFFINDOR));
                case 2 ->
                        utility.printTable(sortAndFilterHandler.filterByHouse(new ArrayList<>(teachersController.readAllTeachers()), FilterByHouseOption.HUFFLEPUFF));
                case 3 ->
                        utility.printTable(sortAndFilterHandler.filterByHouse(new ArrayList<>(teachersController.readAllTeachers()), FilterByHouseOption.RAVENCLAW));
                case 4 ->
                        utility.printTable(sortAndFilterHandler.filterByHouse(new ArrayList<>(teachersController.readAllTeachers()), FilterByHouseOption.SLYTHERIN));
                case 0 -> back = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
