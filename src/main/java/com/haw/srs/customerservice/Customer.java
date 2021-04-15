package com.haw.srs.customerservice;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // spezifiziert dass diese Klasse eine Entität ist und sie wird einer Datenbanktabelle zugeordnet
@Data // sowohl getters als auch setters werden definiert
@AllArgsConstructor //ein Konstruktor mit allen Attributen wird generiert
@NoArgsConstructor(access = AccessLevel.PRIVATE) //der Konstruktor ist nur innerhalb der Klasse aufrufbar
public class Customer {

    @Id // sagt der Datenbank dass das Feld der Primärschlüssel ist
    @GeneratedValue(strategy = GenerationType.AUTO) // wird von der Datenbank festgelegt. Dem Customer wird eine Id automatisch zugewiesen
    private Long id;

    private String firstName;

    private String lastName;

    private Gender gender;

    private String email;

    private PhoneNumber phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // 1 zu n Beziehung: ein Customer hat eine oder mehrere Reservierungen
    //@JoinColumn(name="customerId") // generiert dann keine Jointabelle
    @Setter(AccessLevel.NONE)
    private List<Reservation> reservations = new ArrayList<>();

    public Customer(String firstName, String lastName, Gender gender, String email, PhoneNumber phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = null;
        this.phoneNumber = null;
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }
}
