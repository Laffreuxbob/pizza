package fr.epsi.rennes.poec.bob.dao;

import fr.epsi.rennes.poec.bob.domain.pizza.Ingredient;
import fr.epsi.rennes.poec.bob.domain.pizza.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@Repository
public class PizzaDAO {

    @Autowired
    private DataSource ds;

    public DataSource getDs() {
        return this.ds;
    }

    public List<Pizza> getAllPizza() throws SQLException {
        System.out.println("DAOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");

        List<Pizza> pizzas = new ArrayList<>();

        String sqlSelect = "SELECT p.name as pizza, GROUP_CONCAT(ingredient.name) as ingredient FROM pizza as p RIGHT JOIN pizza_has_ingredient ON pizza_has_ingredient.pizza_id = p.id LEFT JOIN ingredient ON pizza_has_ingredient.ingredient_id = ingredient.id GROUP BY p.name";
        String sql = "Select * FROM pizza";
        Statement stmt = ds.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(sqlSelect);
        while (rs.next()) {
            Pizza current_pizza = new Pizza();
            current_pizza.setName(rs.getString(1));
            current_pizza.debug();
            ArrayList<Ingredient> ingredients = new ArrayList<>();
            String ingredientString = rs.getString(2);

            String[] res = ingredientString.split(",", 0);
            for(String name: res) {
                Ingredient temp = new Ingredient();
                temp.setName(name);
                temp.debug();
                ingredients.add(temp);

            }
            current_pizza.setIngredient(ingredients);
            System.out.println(current_pizza.getClass());
            pizzas.add(current_pizza);
        }

        //////////////////////////////////////////
//        ArrayList<String> pizzasToFront = new ArrayList<>();
//        for (Pizza pizza : pizzas) {
//            String name = pizza.getName();
//            pizzasToFront.add(name);
//        }
        //////////////////////////////////////////
        System.out.println(pizzas.getClass());
        return pizzas;
    }


}
