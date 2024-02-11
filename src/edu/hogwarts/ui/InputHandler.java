package edu.hogwarts.ui;

import edu.hogwarts.model.House;
import edu.hogwarts.model.EmpType;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

public class InputHandler {
    Scanner sc = new Scanner(System.in);

    public int getChoice() {
        System.out.println("Enter your choice: ");
        while (!sc.hasNextInt()) {
            System.out.println("That's not a valid number. Please enter a number.");
            sc.next(); // avoid infinite loop
        }
        int choice = sc.nextInt();
        sc.nextLine(); // Consume the newline left-over
        return choice;
    }

    public UUID getUUID() {
        System.out.println("Enter the ID (UUID): ");
        while (true) {
            try {
                return UUID.fromString(sc.next().trim());
            } catch (IllegalArgumentException e) {
                System.out.println("That's not a valid UUID. Please enter a valid UUID.");
            }
        }
    }

    public String getStringInput(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    public String[] getStringArrayInput(String prompt) {
        System.out.println(prompt + " (comma-separated, e.g., Quidditch, Dueling Club):");
        String input = sc.next();
        String[] items = input.split(",");
        // return each item trimmed of whitespace and leading/trailing commas (if any) as a new String array
        return Arrays.stream(items).map(String::trim).toArray(String[]::new);
    }

    public int getIntInput(String prompt) {
        System.out.println(prompt);
        while (!sc.hasNextInt()) {
            System.out.println("That's not a valid number. Please enter a number.");
            sc.next(); // avoid infinite loop
        }
        int input = sc.nextInt();
        sc.nextLine(); // Consume the newline left-over
        return input;
    }

    public LocalDate getDateInput(String prompt) {
        System.out.println(prompt);
        int year = getIntInput("Enter the year (yyyy):");
        int month = getIntInput("Enter the month (mm):");
        int day = getIntInput("Enter the day (dd):");

        while (true) {
            try {
                return LocalDate.of(year, month, day);
            } catch (DateTimeException e) {
                System.out.println("Invalid date. Please enter a valid date:");
                year = getIntInput("Enter the year (yyyy):");
                month = getIntInput("Enter the month (mm):");
                day = getIntInput("Enter the day (dd):");
            }
        }
    }

    public House getHouseInput() {
        System.out.println("Choose a house:");
        System.out.println("1. Gryffindor");
        System.out.println("2. Hufflepuff");
        System.out.println("3. Ravenclaw");
        System.out.println("4. Slytherin");

        while (true) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    return House.getGryffindor();
                }
                case 2 -> {
                    return House.getHufflepuff();
                }
                case 3 -> {
                    return House.getRavenclaw();
                }
                case 4 -> {
                    return House.getSlytherin();
                }
                default -> System.out.println("Invalid choice, please select a valid house (1-4):");
            }
        }
    }

    public boolean getBooleanInput(String prompt) {
        System.out.println(prompt);
        System.out.println("True or False?");
        System.out.println("1. True");
        System.out.println("2. False");

        while (true) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    return true;
                }
                case 2 -> {
                    return false;
                }
                default -> System.out.println("Invalid choice, please select true or false (1-2):");
            }
        }
    }

    public EmpType getEmpTypeInput() {
        System.out.println("Choose an employee type:");
        System.out.println("1. Teacher");
        System.out.println("2. Janitor");
        System.out.println("3. Headmaster");
        System.out.println("4. Groundskeeper");
        System.out.println("5. Librarian");
        System.out.println("6. Nurse");
        while (true) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    return EmpType.TEACHER;
                }
                case 2 -> {
                    return EmpType.JANITOR;
                }
                case 3 -> {
                    return EmpType.HEADMASTER;
                }
                case 4 -> {
                    return EmpType.GROUNDSKEEPER;
                }
                case 5 -> {
                    return EmpType.LIBRARIAN;
                }
                case 6 -> {
                    return EmpType.NURSE;
                }
                default -> System.out.println("Invalid choice, please select a valid employee type (1-6):");
            }
        }
    }

}
