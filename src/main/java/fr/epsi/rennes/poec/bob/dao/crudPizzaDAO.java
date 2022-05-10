package fr.epsi.rennes.poec.bob.dao;

import fr.epsi.rennes.poec.bob.domain.pizza.Ingredient;
import fr.epsi.rennes.poec.bob.domain.pizza.Pizza;
import fr.epsi.rennes.poec.bob.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class crudPizzaDAO {

    @Autowired
    private DataSource ds;

    public DataSource getDs() {
        return this.ds;
    }

    public List<Ingredient> getAllIngredientObject() throws SQLException {

        List<Ingredient> ingredients = new ArrayList<>();

        String sql = "SELECT name FROM ingredient";

        Statement stmt = ds.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Ingredient current_ingredient = new Ingredient();
            current_ingredient.setName(rs.getString(1));
            // current_ingredient.debug();
            ingredients.add(current_ingredient);
        }
        // System.out.println(ingredients);
        return ingredients;
    }


    public void createPizza(Pizza pizza) throws SQLException {
        System.out.println("CREATE PIZZA");
        String sql = "INSERT INTO pizza (name, ingredients) VALUES ('" +
                pizza.getName() + "', '" + "new ingredients" + "');";
        System.out.println(sql);
        // Statement stmt = ds.getConnection().createStatement();
        // stmt.executeUpdate(sql);
    }
}

