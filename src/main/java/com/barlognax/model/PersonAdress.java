package com.barlognax.model;

import javax.persistence.*;


@Entity
@Table(name = "person_adress")
public class PersonAdress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;
    private String city;
    private String street;

    @Column(name = "number_of_house")
    private String numberOfHouse;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public PersonAdress() {
    }

    public PersonAdress(Long id, String country, String city, String street, String numberOfHouse) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.numberOfHouse = numberOfHouse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumberOfHouse() {
        return numberOfHouse;
    }

    public void setNumberOfHouse(String numberOfHouse) {
        this.numberOfHouse = numberOfHouse;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
