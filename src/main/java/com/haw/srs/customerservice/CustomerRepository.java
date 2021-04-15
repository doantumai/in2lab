package com.haw.srs.customerservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // DAO (Data Access Object Klasse: DAO stellt ein Pattern dar,
            // dass auf einheitliche Weise den Zugriff auf Datenquellen kapselt)
public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {

    Optional<Customer> findByLastName(String lastName);
}
