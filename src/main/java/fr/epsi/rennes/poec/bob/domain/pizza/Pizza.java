package fr.epsi.rennes.poec.bob.domain.pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private ArrayList<Ingredient> ingredient = new ArrayList<>();
    private int price;

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredient(ArrayList<Ingredient> ingredient) {
        this.ingredient = ingredient;
    }

    public void debug() {
        System.out.println(this.name);
    }

    public String getName() {
        return this.name;
    }
}
