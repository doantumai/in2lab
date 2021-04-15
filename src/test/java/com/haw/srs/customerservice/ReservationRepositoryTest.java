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
    private CustomerRepository customerRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private MovieRepository movieRepository;

    @BeforeEach
    void setUp(){
        customerRepository.deleteAll();
        reservationRepository.deleteAll();
        movieRepository.deleteAll();

        Reservation reservation1 = new Reservation(new Movie("Highschool Musical"));
        reservationRepository.save(reservation1);
    }

    @Test
    void getReservationSuccess() {
        Optional<Movie> movie = movieRepository.findByTitle("Highschool Musical");

        assertTrue(this.reservationRepository.findByMovie(movie).isPresent());
    }
}