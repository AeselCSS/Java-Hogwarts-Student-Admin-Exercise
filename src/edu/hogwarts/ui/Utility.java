package edu.hogwarts.ui;

import edu.hogwarts.model.HogwartsPerson;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Utility {
    private final SortAndFilterHandler sortAndFilterHandler;
    public Utility() {
        this.sortAndFilterHandler = new SortAndFilterHandler();
    }

    public void handleSort(ArrayList<HogwartsPerson> people, SortByOption sortByOption, SortDirectionOption sortDirection) {
        switch (sortByOption) {
            case FIRST_NAME -> printTable(sortAndFilterHandler.sortByFirstName(people, sortDirection));
            case MIDDLE_NAME -> printTable(sortAndFilterHandler.sortByMiddleName(people, sortDirection));
            case LAST_NAME -> printTable(sortAndFilterHandler.sortByLastName(people, sortDirection));
            case AGE -> printTable(sortAndFilterHandler.sortByAge(people, sortDirection));
            case HOUSE -> printTable(sortAndFilterHandler.sortByHouse(people, sortDirection));
            case ROLE -> printTable(sortAndFilterHandler.sortByRole(people, sortDirection));
        }
    }

    // === Table Printing ===
    public void printTable(@NotNull ArrayList<HogwartsPerson> persons) {
        if (persons.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        // find max length of each column
        String fName = "First Name";
        String mName = "Middle Name";
        String lName = "Last Name";
        String age = "Age";
        String house = "House";
        String role = "Role";

        int maxFirstNameLength = fName.length();
        int maxMiddleNameLength = mName.length();
        int maxLastNameLength = lName.length();
        int maxDobLength = age.length();
        int maxHouseLength = house.length();
        int maxRoleLength = role.length();

        for (HogwartsPerson person : persons) {
            String roleName = (person.getClass().getSimpleName().split("s"))[1];

            // find max length of each column with Math.max() by comparing the current max length with the length of the current person's attribute
            maxFirstNameLength = Math.max(maxFirstNameLength, safeStringLength(person.getFirstName()));
            maxMiddleNameLength = Math.max(maxMiddleNameLength, safeStringLength(person.getMiddleName()));
            maxLastNameLength = Math.max(maxLastNameLength, safeStringLength(person.getLastName()));
            maxDobLength = Math.max(maxDobLength, person.getAge().toString().length());
            maxHouseLength = Math.max(maxHouseLength, person.getHouse().getName().length());
            maxRoleLength = Math.max(maxRoleLength, roleName.length());
        }


        // table header
        String border = "+" + "-".repeat(maxFirstNameLength + 2) + "-".repeat(maxMiddleNameLength + 2) + "-".repeat(maxLastNameLength + 2) + "+" + "-".repeat(maxDobLength + 2) + "+" + "-".repeat(maxHouseLength + 2) + "+" + "-".repeat(maxRoleLength + 2) + "+";
        System.out.println(border);
        System.out.println(
                "| " + center(fName, maxFirstNameLength) +
                        " | " + center(mName, maxMiddleNameLength) +
                        " | " + center(lName, maxLastNameLength) +
                        " | " + center(age, maxDobLength) +
                        " | " + center(house, maxHouseLength) +
                        " | " + center(role, maxRoleLength) +
                        " |");
        System.out.println(border);

        // table body
        for (HogwartsPerson person : persons) {
            String roleName = (person.getClass().getSimpleName().split("s"))[1];
            System.out.println(
                    "| " + center(safeString(person.getFirstName()), maxFirstNameLength) +
                            " | " + center(safeString(person.getMiddleName()), maxMiddleNameLength) +
                            " | " + center(safeString(person.getLastName()), maxLastNameLength) +
                            " | " + center(person.getAge().toString(), maxDobLength) +
                            " | " + center(person.getHouse().getName(), maxHouseLength) +
                            " | " + center(roleName, maxRoleLength) +
                            " |");
        }

        // table footer
        System.out.println(border);
    }

    private String center(@NotNull String text, int length) {
        if (text.length() >= length) {
            return text;
        }
        int paddingLeft = (length - text.length()) / 2;
        int paddingRight = length - text.length() - paddingLeft;
        return " ".repeat(paddingLeft) + text + " ".repeat(paddingRight);
    }

    // === Safe String Handling ===
    private int safeStringLength(String str) {
        // return the length of the string, or 0 if the string is null
        return str != null ? str.length() : 0;
    }

    private String safeString(String str) {
        // Return the string, or "N/A" if the string is null
        return str != null ? str : "N/A";
    }
}
