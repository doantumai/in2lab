package com.haw.srs.customerservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.Table;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles(profiles = "testing")
class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private MovieRepository movieRepository;

    @BeforeEach
    void setUp(){
        Reservation reservation1 = new Reservation(new Movie("Highschool Musical"));
        Reservation reservation2 = new Reservation(new Movie("Highschool Musical 2"));
        Reservation reservation3 = new Reservation(new Movie("Highschool Musical 3"));

        reservationRepository.save(reservation1);
        reservationRepository.save(reservation2);
        reservationRepository.save(reservation3);
    }

    @Test
    void getReservationSuccess(){
       Optional<Movie> movie = movieRepository.findByTitle("Highschool Musical");
       Optional<Movie> movie2 = movieRepository.findByTitle("Highschool Musical 2");
       Optional<Movie> movie3 = movieRepository.findByTitle("Highschool Musical 3");

       this.reservationRepository.findByMovie(movie).isPresent();
       this.reservationRepository.findByMovie(movie2).isPresent();
       this.reservationRepository.findByMovie(movie3).isPresent();
    }
}