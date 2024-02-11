package edu.hogwarts.model;

public class House {
    private String name;
    private String founder;
    private String[] colors;
    private static final House GRYFFINDOR = new House("Gryffindor", "Godric Gryffindor", "scarlet", "gold");
    private static final House HUFFLEPUFF = new House("Hufflepuff", "Helga Hufflepuff", "yellow", "black");
    private static final House RAVENCLAW = new House("Ravenclaw", "Rowena Ravenclaw", "blue", "silver");
    private static final House SLYTHERIN = new House("Slytherin", "Salazar Slytherin", "green", "silver");

    public House(String name, String founder, String... colors) {
        this.name = name;
        this.founder = founder;
        this.colors = colors;
    }

    public House() {

    }

    public static House getGryffindor() {
        return GRYFFINDOR;
    }

    public static House getHufflepuff() {
        return HUFFLEPUFF;
    }

    public static House getRavenclaw() {
        return RAVENCLAW;
    }

    public static House getSlytherin() {
        return SLYTHERIN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String[] getColors() {
        return colors;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    @Override
    public String toString() {
        var colorsString = new StringBuilder();
        for (String color : colors) {
            colorsString.append(color).append(", ");
        }
        return "House " + name + ", founded by " + getFounder() + ", colors: " + colorsString + "\n";
    }
}
