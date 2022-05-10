package fr.epsi.rennes.poec.bob.controller;

import fr.epsi.rennes.poec.bob.domain.pizza.Ingredient;
import fr.epsi.rennes.poec.bob.domain.pizza.Pizza;
import fr.epsi.rennes.poec.bob.service.crudPizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class crudPizzaController {

    @Autowired
    private crudPizzaService crudPizzaService;

    @GetMapping("/admin/crudpizza")
    public List<Ingredient> getAllIngredientObject() throws SQLException {
        System.out.println("CRUD PIZZA CONTROLLER getAllIngredientObject");
        return crudPizzaService.getAllIngredientObject();
    }

    //@PostMapping( value="/admin/crudpizza", consumes={"application/json"} )
    //@PostMapping(value="/admin/crudpizza", consumes="multipart/form-data" )
    //@PostMapping(value="/admin/crudpizza", consumes = "application/x-www-form-urlencoded")
    @PostMapping(value="/admin/crudpizza")
    public void createPizza(@RequestBody Pizza new_pizza) {
        System.out.println(new_pizza);
        System.out.println(new_pizza.debug());
        this.crudPizzaService.createPizza(new_pizza);
    }
}
