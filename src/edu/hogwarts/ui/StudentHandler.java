package edu.hogwarts.ui;

import edu.hogwarts.controller.StudentController;
import edu.hogwarts.model.HogwartsPerson;
import edu.hogwarts.model.HogwartsStudent;
import edu.hogwarts.model.House;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class StudentHandler {
    private final MenuHandler menuHandler;
    private final InputHandler inputHandler;
    private final SortAndFilterHandler sortAndFilterHandler;
    private final StudentController studentController;
    private final Utility utility;

    public StudentHandler(@NotNull StudentController studentController) {
        this.studentController = studentController;
        this.menuHandler = new MenuHandler();
        this.inputHandler = new InputHandler();
        this.sortAndFilterHandler = new SortAndFilterHandler();
        this.utility = new Utility();
    }


    // === Student Menu ===
    public void handleStudentMenu() {
        boolean back = false;
        while (!back) {
            menuHandler.showStudentMenu();
            int choice = inputHandler.getChoice();
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> editStudent();
                case 3 -> deleteStudent();
                case 4 -> handleSortOrFilterStudents();
//                case 4 -> utility.printTable(new ArrayList<>(studentController.readAllStudents()));
                case 0 -> back = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addStudent() {
        HogwartsStudent student = new HogwartsStudent();

        String fullName = inputHandler.getStringInput("Enter full name:");
        student.setFullName(fullName);

        LocalDate dateOfBirth = inputHandler.getDateInput("Enter date of birth (yyyy-mm-dd):");
        student.setDateOfBirth(dateOfBirth);

        int enrollmentYear = inputHandler.getIntInput("Enter enrollment year:");
        student.setEnrollmentYear(enrollmentYear);

        int graduationYear = inputHandler.getIntInput("Enter graduation year:");
        student.setGraduationYear(graduationYear);

        Boolean graduated = inputHandler.getBooleanInput("Has the student graduated?");
        student.setGraduated(graduated);

        House house = inputHandler.getHouseInput();
        student.setHouse(house);

        boolean prefect = inputHandler.getBooleanInput("Is the student a prefect?");
        student.setPrefect(prefect);

        String[] teams = inputHandler.getStringArrayInput("Enter teams (comma separated):");
        student.setTeams(teams);

        studentController.createStudent(student);
        System.out.println("Student added successfully.");
    }

    private void editStudent() {
        UUID id = inputHandler.getUUID();
        HogwartsStudent student = studentController.readStudent(id);
        if (student != null) {
            // Prompt user for new details
            // name
            String newName = inputHandler.getStringInput("Enter new name:");
            student.setFullName(newName);
            // date of birth
            LocalDate newDob = inputHandler.getDateInput("Enter new date of birth (yyyy-mm-dd):");
            student.setDateOfBirth(newDob);
            // enrollment year
            LocalDate newEnrollmentDate = inputHandler.getDateInput("Enter new enrollment date (yyyy-mm-dd):");
            student.setEnrollmentYear(newEnrollmentDate.getYear());
            // graduation year
            LocalDate newGraduationDate = inputHandler.getDateInput("Enter new graduation date (yyyy-mm-dd):");
            student.setGraduationYear(newGraduationDate.getYear());
            // graduated
            boolean newGraduated = inputHandler.getBooleanInput("Has the student graduated?");
            student.setGraduated(newGraduated);
            // house
            House newHouse = inputHandler.getHouseInput();
            student.setHouse(newHouse);
            // prefect
            boolean newPrefect = inputHandler.getBooleanInput("Is the student a prefect?");
            student.setPrefect(newPrefect);
            // teams
            String[] newTeams = inputHandler.getStringArrayInput("Enter new teams (comma separated):");
            student.setTeams(newTeams);
            // update student
            studentController.updateStudent(student);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private void deleteStudent() {
        UUID id = inputHandler.getUUID();
        HogwartsStudent student = studentController.readStudent(id);
        if (student != null) {
            studentController.deleteStudent(id);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private void handleSortOrFilterStudents() {
        boolean back = false;
        while (!back) {
            menuHandler.showSortOrFilterMenu();
            int choice = inputHandler.getChoice();
            switch (choice) {
                case 1 -> sortStudents();
                case 2 -> filterStudents();
                case 0 -> back = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void sortStudents() {
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
        ArrayList<HogwartsPerson> students = new ArrayList<>(studentController.readAllStudents());

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

    private void filterStudents() {
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
                        utility.printTable(sortAndFilterHandler.filterByHouse(new ArrayList<>(studentController.readAllStudents()), FilterByHouseOption.GRYFFINDOR));
                case 2 ->
                        utility.printTable(sortAndFilterHandler.filterByHouse(new ArrayList<>(studentController.readAllStudents()), FilterByHouseOption.HUFFLEPUFF));
                case 3 ->
                        utility.printTable(sortAndFilterHandler.filterByHouse(new ArrayList<>(studentController.readAllStudents()), FilterByHouseOption.RAVENCLAW));
                case 4 ->
                        utility.printTable(sortAndFilterHandler.filterByHouse(new ArrayList<>(studentController.readAllStudents()), FilterByHouseOption.SLYTHERIN));
                case 0 -> back = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
