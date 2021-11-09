package com.barlognax.repository;

import com.barlognax.model.PersonAdress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonAdressRepository extends JpaRepository<PersonAdress, Long> {

    List<PersonAdress> findAllByPersonId(Long id);

}
