package it.fivenet.library.controllers;

import it.fivenet.library.services.ServizioPrenotazione;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerPrenotazione {
    private final ServizioPrenotazione servizioPrenotazione;

    public ControllerPrenotazione(ServizioPrenotazione servizioPrenotazione) {
        this.servizioPrenotazione = servizioPrenotazione;
    }

    @RequestMapping("/prenotazioni")
    public String getPrenotazioni(Model model) {

        model.addAttribute("prenotazioni", servizioPrenotazione.findAll());

        return "prenotazioni";
    }

}