package it.fivenet.library.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idP;
    private Date inizioPrenotazione;
    private Date scadenza;
    private boolean restituito;

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public Date getInizioPrenotazione() {
        return inizioPrenotazione;
    }

    public void setInizioPrenotazione(Date inizioPrenotazione) {
        this.inizioPrenotazione = inizioPrenotazione;
    }

    public Date getScadenza() {
        return scadenza;
    }

    public void setScadenza(Date scadenza) {
        this.scadenza = scadenza;
    }

    public boolean isRestituito() {
        return restituito;
    }

    public void setRestituito(boolean restituito) {
        this.restituito = restituito;
    }


    @Override
    public String toString() {
        return "Prenotazione{" +
                "idP=" + idP +
                ", inizioPrenotazione=" + inizioPrenotazione +
                ", scadenza=" + scadenza +
                ", restituito=" + restituito +
                '}';
    }
}
