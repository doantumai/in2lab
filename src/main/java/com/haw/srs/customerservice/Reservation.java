package com.haw.srs.customerservice;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int sitNr;

    private int hallNr;

    @OneToOne(cascade=CascadeType.ALL) // einer Resevierung ist genau ein Movie zugeordnet
    private Movie movie;

    @Autowired
    public Reservation(Movie movie) {

        this.movie = movie;
    }
}
