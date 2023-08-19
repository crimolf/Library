package it.fivenet.library.domain;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Autore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idA;
    private String nome;
    private String cognome;

    @ManyToMany(mappedBy = "autori")
    private Set<Libro> libri=new HashSet<>();





    public Set<Libro> getLibri() {
        return libri;
    }

    public void setLibri(Set<Libro> libri) {
        this.libri = libri;
    }

    public int getIdA() {
        return idA;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }




    @Override
    public String toString() {
        return "Autore{" +
                "idA=" + idA +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", libri=" + libri +
                '}';
    }
}
