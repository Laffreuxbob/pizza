package fr.epsi.rennes.poec.bob.controller;

import fr.epsi.rennes.poec.bob.domain.pizza.Pizza;
import fr.epsi.rennes.poec.bob.service.pizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class pizzaController {

    @Autowired
    private pizzaService pizzaService;

//    @GetMapping("/user/pizza")
//    public String getAllPizza(Model model) {
//        model.addAttribute("getAllPizza", pizzaService.getAllPizza());
//        return "user/pizza";
//    }

    @GetMapping("/user/pizza")
    public List<Pizza> getAllPizza() throws SQLException {
        System.out.println("CONTROOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOLLER");
        return pizzaService.getAllPizza();
    }
}
