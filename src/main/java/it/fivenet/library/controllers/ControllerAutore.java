package it.fivenet.library.controllers;

import it.fivenet.library.services.ServizioAutore;
import it.fivenet.library.services.ServizioLibro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerAutore {
    private final ServizioAutore servizioAutore;

    public ControllerAutore(ServizioAutore servizioAutore) {
        this.servizioAutore = servizioAutore;
    }

    @RequestMapping("/autori")
    public String getAutori(Model model) {

        model.addAttribute("autori", servizioAutore.findAll());

        return "autori";
    }

}