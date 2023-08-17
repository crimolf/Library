package it.fivenet.library.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idP;
    private Date inizioPrenotazione;
    private Date scadenza;
    private boolean restituito;

    @OneToMany(mappedBy = "prenotazione")
    private Set<Libro> libri;



    public Set<Libro> getLibri() {
        return libri;
    }
    public void setLibri(Set<Libro> libri) {
        this.libri = libri;
    }



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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prenotazione that = (Prenotazione) o;
        return idP == that.idP && restituito == that.restituito && Objects.equals(inizioPrenotazione, that.inizioPrenotazione) && Objects.equals(scadenza, that.scadenza) && Objects.equals(libri, that.libri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idP, inizioPrenotazione, scadenza, restituito, libri);
    }
}
