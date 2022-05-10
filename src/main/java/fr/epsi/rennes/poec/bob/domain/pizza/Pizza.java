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

    // A PASSER EN LOGGER /!\
    public String debug() {
        String pizza = this.name;
        for (Ingredient ingredient: this.ingredient) {
            pizza += ingredient.getName() + ", ";
        }
        System.out.println(pizza);
        return pizza;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Ingredient> getIngredient() {
        return ingredient;
    }
}
