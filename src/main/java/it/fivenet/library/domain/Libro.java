package it.fivenet.library.domain;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Libro {
    @Id
    private int ISBN;
    private String titolo;
    private String testo;


    @ManyToMany
    @JoinTable(name = "autore_libro", joinColumns = @JoinColumn(name = "libro_ISBN"),
            inverseJoinColumns = @JoinColumn(name = "autore_idA"))
    private Set<Autore> autori = new HashSet<>();

    @ManyToOne
    private Prenotazione prenotazione;

    public Set<Autore> getAutori() {
        return autori;
    }

    public void setAutori(Set<Autore> autori) {
        this.autori = autori;
    }

    public Prenotazione getPrenotazione() {
        return prenotazione;
    }

    public void setPrenotazione(Prenotazione prenotazione) {
        this.prenotazione = prenotazione;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "ISBN=" + ISBN +
                ", titolo='" + titolo + '\'' +
                ", testo='" + testo + '\'' +
                ", autori=" + autori +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return ISBN == libro.ISBN && Objects.equals(titolo, libro.titolo) && Objects.equals(testo, libro.testo) && Objects.equals(autori, libro.autori) && Objects.equals(prenotazione, libro.prenotazione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN, titolo, testo, autori, prenotazione);
    }
}
