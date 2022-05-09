package fr.epsi.rennes.poec.bob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication(scanBasePackages = "fr.epsi.rennes.poec.bob")
public class PizzaApplication {

    public static void main(String[] args) throws SQLException {
        System.out.println("Start Pizza");
        SpringApplication.run(PizzaApplication.class, args);

    }
}
