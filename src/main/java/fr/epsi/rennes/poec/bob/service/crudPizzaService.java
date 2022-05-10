package fr.epsi.rennes.poec.bob.service;

import fr.epsi.rennes.poec.bob.dao.crudPizzaDAO;
import fr.epsi.rennes.poec.bob.domain.pizza.Ingredient;
import fr.epsi.rennes.poec.bob.domain.pizza.Pizza;
import fr.epsi.rennes.poec.bob.domain.user.User;
import fr.epsi.rennes.poec.bob.domain.user.UserRole;
import fr.epsi.rennes.poec.bob.exception.TechnicalException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class crudPizzaService {

    private static final Logger logger = LogManager.getLogger(Pizza.class.getName());

    @Autowired
    private crudPizzaDAO dao;

    public List<Ingredient> getAllIngredientObject() throws SQLException {
        System.out.println("CRUD PIZZA SERVICE getAllIngredientObject");

        try {
            return dao.getAllIngredientObject();
        } catch (SQLException e) {
            System.out.println("ERROR");
            logger.error(e.getMessage(), e);
            System.out.println("ERROR");
            throw e;
        }
    }


    public void createPizza(Pizza pizza) {
        try {
            dao.createPizza(pizza);
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
            throw new TechnicalException(e);
        }
    }
}
