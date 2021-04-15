package com.haw.srs.customerservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles(profiles = "testing")
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @BeforeEach
    void setUp(){
        //this.movieRepository.deleteAll(); movie steht mit reservations in einer Beziehung -> das Löschen vom movieRepository führt zu einem Error

        Movie movie1 = new Movie("Highschool Musical");
        Movie movie2 = new Movie("Highschool Musical 2");
        Movie movie3 = new Movie("Highschool Musical 3");

        movieRepository.save(movie1);
        movieRepository.save(movie2);
        movieRepository.save(movie3);
    }

    @Test
    void getMovieSuccess(){
        this.movieRepository.findByTitle("Highschool Musical").isPresent();
        this.movieRepository.findByTitle("Highschool Musical 2").isPresent();
        this.movieRepository.findByTitle("Highschool Musical 3").isPresent();
    }
}