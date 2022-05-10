package fr.epsi.rennes.poec.bob.controller;


import fr.epsi.rennes.poec.bob.domain.user.User;
import fr.epsi.rennes.poec.bob.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/public/register")
    public void addUser (User user) {
        this.userService.addUser(user);
    }
}
