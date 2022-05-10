package fr.epsi.rennes.poec.bob.dao;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mysql.cj.xdevapi.JsonArray;
import fr.epsi.rennes.poec.bob.domain.pizza.Ingredient;
import fr.epsi.rennes.poec.bob.domain.pizza.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class PizzaDAO {

    @Autowired
    private DataSource ds;

    public DataSource getDs() {
        return this.ds;
    }

    public List<Pizza> getAllPizzaObject() throws SQLException {
        System.out.println("PIZZA DAO getAllPizzaObject");

        List<Pizza> pizzas = new ArrayList<>();

        String sqlSelect = "SELECT p.name as pizza, GROUP_CONCAT(ingredient.name) as ingredient " +
                "FROM pizza as p " +
                "RIGHT JOIN pizza_has_ingredient ON pizza_has_ingredient.pizza_id = p.id " +
                "LEFT JOIN ingredient ON pizza_has_ingredient.ingredient_id = ingredient.id " +
                "GROUP BY p.name";
        // String sql = "Select * FROM pizza";
        Statement stmt = ds.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(sqlSelect);
        while (rs.next()) {
            Pizza current_pizza = new Pizza();
            current_pizza.setName(rs.getString(1));
            // current_pizza.debug();
            ArrayList<Ingredient> ingredients = new ArrayList<>();
            String ingredientString = rs.getString(2);

            String[] res = ingredientString.split(",", 0);
            for(String name: res) {
                Ingredient temp = new Ingredient();
                temp.setName(name);
                // temp.debug();
                ingredients.add(temp);

            }
            // System.out.println(ingredients);
            current_pizza.setIngredient(ingredients);
            current_pizza.debug();
            pizzas.add(current_pizza);
        }

        //////////////////////////////////////////
//        ArrayList<String> pizzasToFront = new ArrayList<>();
//        for (Pizza pizza : pizzas) {
//            String name = pizza.getName();
//            pizzasToFront.add(name);
//        }
        //////////////////////////////////////////
        // System.out.println(pizzas.getClass());
        System.out.println(pizzas);
        return pizzas;
    }

    public void getAllPizza() throws SQLException {
    //public List<String> getAllPizza() throws SQLException {
        System.out.println("PIZZA DAO getAllPizza");

        List<String> pizzas = new ArrayList<>();

        Map<String, List<String>> output = new HashMap<>();

        String sqlSelect = "SELECT p.name as pizza, GROUP_CONCAT(ingredient.name) as ingredient FROM pizza as p RIGHT JOIN pizza_has_ingredient ON pizza_has_ingredient.pizza_id = p.id LEFT JOIN ingredient ON pizza_has_ingredient.ingredient_id = ingredient.id GROUP BY p.name";
        Statement stmt = ds.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(sqlSelect);
        while (rs.next()) {
            Pizza current_pizza = new Pizza();

            current_pizza.setName(rs.getString(1));

            ArrayList<Ingredient> ingredients = new ArrayList<>();
            String ingredientString = rs.getString(2);

            String[] res = ingredientString.split(",", 0);
//            for(String name: res) {
//
//                Ingredient temp = new Ingredient();
//                temp.setName(name);
//                ingredients.add(temp);
//
//            }
            output.put(current_pizza.getName(), List.of(res));


            // current_pizza.setIngredient(ingredients);
            // current_pizza.debug();
            // pizzas.add(current_pizza.debug());


        }
        // return (List<String>) output;
    }


}
