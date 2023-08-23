package it.fivenet.playground.library.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Libro {

    private @Id
    @GeneratedValue Long id;
    private String titolo;
    private String testo;

    Libro() {
    }

    public Libro(String titolo, String testo) {

        this.titolo = titolo;
        this.testo = testo;
    }

    public Long getId() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(id, libro.id) && Objects.equals(titolo, libro.titolo) && Objects.equals(testo, libro.testo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titolo, testo);
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "ID=" + id +
                ", titolo='" + titolo + '\'' +
                ", testo='" + testo + '\'' +
                '}';
    }
}
