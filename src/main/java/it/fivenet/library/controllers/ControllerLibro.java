package it.fivenet.library.controllers;

import it.fivenet.library.services.ServizioLibro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerLibro {
    private final ServizioLibro servizioLibro;

    public ControllerLibro(ServizioLibro servizioLibro) {
        this.servizioLibro = servizioLibro;
    }

    @RequestMapping("/libri")
    public String getBooks(Model model) {

        model.addAttribute("libri", servizioLibro.findAll());

        return "libri";
    }

}