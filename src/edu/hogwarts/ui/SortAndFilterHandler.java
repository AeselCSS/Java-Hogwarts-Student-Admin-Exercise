package edu.hogwarts.ui;

import edu.hogwarts.model.HogwartsPerson;
import edu.hogwarts.model.HogwartsStudent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortAndFilterHandler {

    public ArrayList<HogwartsPerson> sortByFirstName(ArrayList<HogwartsPerson> persons, SortDirectionOption sortDirection) {
        ArrayList<HogwartsPerson> sortedList = new ArrayList<>(persons);
        if (sortDirection == SortDirectionOption.ASCENDING) {
            sortedList.sort(Comparator.comparing(HogwartsPerson::getFirstName));
        } else {
            sortedList.sort(Comparator.comparing(HogwartsPerson::getFirstName).reversed());
        }
        return sortedList;
    }

    public ArrayList<HogwartsPerson> sortByMiddleName(List<HogwartsPerson> persons, SortDirectionOption sortDirection) {
        ArrayList<HogwartsPerson> sortedList = new ArrayList<>(persons);
        Comparator<HogwartsPerson> middleNameComparator = Comparator.comparing(HogwartsPerson::getMiddleName,
                Comparator.nullsLast(Comparator.naturalOrder())); // Handle nulls by placing them last

        if (sortDirection == SortDirectionOption.ASCENDING) {
            sortedList.sort(middleNameComparator);
        } else {
            sortedList.sort(middleNameComparator.reversed());
        }
        return sortedList;
    }

    public ArrayList<HogwartsPerson> sortByLastName(List<HogwartsPerson> persons, SortDirectionOption sortDirection) {
        ArrayList<HogwartsPerson> sortedList = new ArrayList<>(persons);
        if (sortDirection == SortDirectionOption.ASCENDING) {
            sortedList.sort(Comparator.comparing(HogwartsPerson::getLastName));
        } else {
            sortedList.sort(Comparator.comparing(HogwartsPerson::getLastName).reversed());
        }
        return sortedList;
    }

    public ArrayList<HogwartsPerson> sortByAge(List<HogwartsPerson> persons, SortDirectionOption sortDirection) {
        ArrayList<HogwartsPerson> sortedList = new ArrayList<>(persons);
        if (sortDirection == SortDirectionOption.ASCENDING) {
            sortedList.sort(Comparator.comparing(HogwartsPerson::getAge));
        } else {
            sortedList.sort(Comparator.comparing(HogwartsPerson::getAge).reversed());
        }
        return sortedList;
    }

    public ArrayList<HogwartsPerson> sortByHouse(List<HogwartsPerson> persons, SortDirectionOption sortDirection) {
        ArrayList<HogwartsPerson> sortedList = new ArrayList<>(persons);
        Comparator<HogwartsPerson> houseComparator = Comparator.comparing(person -> person.getHouse().getName());
        if (sortDirection == SortDirectionOption.DESCENDING) {
            houseComparator = houseComparator.reversed();
        }
        sortedList.sort(houseComparator);
        return sortedList;
    }

    public ArrayList<HogwartsPerson> sortByRole(List<HogwartsPerson> persons, SortDirectionOption sortDirection) {
        ArrayList<HogwartsPerson> sortedList = new ArrayList<>(persons);
        if (sortDirection == SortDirectionOption.ASCENDING) {
            sortedList.sort(Comparator.comparing(person -> person.getClass().getSimpleName()));
        } else {
            sortedList.sort(Comparator.comparing(person -> person.getClass().getSimpleName()).reversed());
        }
        return sortedList;
    }

    public ArrayList<HogwartsPerson> filterByHouse(List<HogwartsPerson> persons, FilterByHouseOption houseName) {
        ArrayList<HogwartsPerson> filteredList = new ArrayList<>();
        for (HogwartsPerson person : persons) {
            if (person.getHouse().getName().equalsIgnoreCase(houseName.name())) {
                filteredList.add(person);
            }
        }
        return filteredList;
    }

    public ArrayList<HogwartsPerson> filterByRole(List<HogwartsPerson> persons, FilterByRoleOption role) {
        ArrayList<HogwartsPerson> filteredList = new ArrayList<>();
        for (HogwartsPerson person : persons) {
            String[] roleSplit = person.getClass().getSimpleName().split("s");
            if (roleSplit[1].equalsIgnoreCase(role.name())) {
                filteredList.add(person);
            }
        }
        return filteredList;
    }
}
