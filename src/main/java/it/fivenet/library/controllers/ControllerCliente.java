package it.fivenet.library.controllers;

import it.fivenet.library.services.ServizioCliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerCliente {
    private final ServizioCliente servizioCliente;

    public ControllerCliente(ServizioCliente servizioCliente) {
        this.servizioCliente = servizioCliente;
    }

    @RequestMapping("/clienti")
    public String getClienti(Model model) {

        model.addAttribute("clienti", servizioCliente.findAll());

        return "clienti";
    }

}