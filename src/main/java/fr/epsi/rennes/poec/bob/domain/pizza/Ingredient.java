package fr.epsi.rennes.poec.bob.domain.pizza;

public class Ingredient {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void debug() {
        System.out.println(this.name);
    }
}
