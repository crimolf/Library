package it.fivenet.library.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Cliente {

    @Id
    private String codFis;
    private String nome;
    private String cognome;
    private String residenza;



    @ManyToMany
    @JoinTable(name = "prenotazione_cliente", joinColumns = @JoinColumn(name = "cliente_codFis"),
            inverseJoinColumns = @JoinColumn(name = "prenotazione_idP"))
    private Set<Autore> autori=new HashSet<>();
    public Set<Autore> getAutori() {
        return autori;
    }
    public void setAutori(Set<Autore> autori) {
        this.autori = autori;
    }





    public String getCodFis() {
        return codFis;
    }

    public void setCodFis(String codFis) {
        this.codFis = codFis;
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

    public String getResidenza() {
        return residenza;
    }

    public void setResidenza(String residenza) {
        this.residenza = residenza;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codFis=" + codFis +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", residenza='" + residenza + '\'' +
                '}';
    }
}
