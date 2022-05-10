package fr.epsi.rennes.poec.bob.controller;


import fr.epsi.rennes.poec.bob.domain.Response;
import fr.epsi.rennes.poec.bob.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "redirect:/index.html";
    }

}
