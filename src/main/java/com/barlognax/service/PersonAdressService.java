package com.barlognax.service;

import com.barlognax.model.PersonAdress;
import com.barlognax.repository.PersonAdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonAdressService {
    private final PersonAdressRepository personAdressRepository;

    @Autowired
    public PersonAdressService(PersonAdressRepository personAdressRepository) {
        this.personAdressRepository = personAdressRepository;
    }

    public PersonAdress findById(Long id) {
        return personAdressRepository.getById(id);
    }

    public List<PersonAdress> findAll() {
        return personAdressRepository.findAll();
    }

    public PersonAdress savePersonAdress(PersonAdress personAdress) {
        return personAdressRepository.save(personAdress);
    }

    public void deleteById(Long id) {
        personAdressRepository.deleteById(id);
    }

    public List<PersonAdress> findAllAdressByPersonId(Long id){
        return personAdressRepository.findAllByPersonId(id);
    }
}
