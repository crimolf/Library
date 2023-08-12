package it.fivenet.library.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cliente {

    @Id
    private String codFis;
    private String nome;
    private String cognome;
    private String residenza;

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
