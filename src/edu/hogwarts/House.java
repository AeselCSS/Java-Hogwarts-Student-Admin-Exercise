package edu.hogwarts;

public class House {
    private String name;
    private String founder;
    private String[] colors;

    public House(String name, String founder, String... colors) {
        this.name = name;
        this.founder = founder;
        this.colors = colors;
    }

    public House() {

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
        return "House {\n" +
                "name='" + name + '\'' + "\n" +
                ", founder='" + founder + '\'' + "\n" +
                ", colors=" + colorsString + "\n" +
                '}';
    }
}
