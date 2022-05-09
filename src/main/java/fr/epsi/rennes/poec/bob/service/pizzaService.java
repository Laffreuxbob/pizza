package fr.epsi.rennes.poec.bob.service;

import fr.epsi.rennes.poec.bob.dao.PizzaDAO;
import fr.epsi.rennes.poec.bob.domain.pizza.Pizza;
import fr.epsi.rennes.poec.bob.exception.TechnicalException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class pizzaService {

    private static final Logger logger = LogManager.getLogger(Pizza.class.getName());

    @Autowired
    private PizzaDAO dao;

    public List<Pizza> getAllPizza() throws SQLException {
        System.out.println("SERVIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIICE");

        try {
            return dao.getAllPizza();
        } catch (SQLException e) {
            System.out.println("ERROR");
            logger.error(e.getMessage(), e);
            System.out.println("ERROR");
            throw e;

        }
    }


}
