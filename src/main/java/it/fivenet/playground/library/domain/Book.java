package it.fivenet.playground.library.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.TABLE;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Book {

    private @Id
    @GeneratedValue Long id;
    private String titolo;
    private String testo;
    public int numberBookInStock;
    /*@Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    */
    public int numberBooksOut;
}

