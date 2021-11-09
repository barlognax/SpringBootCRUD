package com.barlognax.controller;

import com.barlognax.model.Person;
import com.barlognax.model.PersonAdress;
import com.barlognax.service.PersonAdressService;
import com.barlognax.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PersonAdressController {

    private final PersonAdressService personAdressService;
    private final PersonService personService;

    @Autowired
    public PersonAdressController(PersonAdressService personAdressService, PersonService personService) {
        this.personAdressService = personAdressService;
        this.personService = personService;
    }

    @GetMapping("/adress/{id}")
    public String PersonAdressForm(@PathVariable("id") Long id, Model model) {
        List<PersonAdress> personAdress = personAdressService.findAllAdressByPersonId(id);
        Person person = personService.findById(id);
        model.addAttribute("personAdress", personAdress);
        model.addAttribute("person", person);
        return "adress";
    }

    @GetMapping("/adress/adress-create/{id}")
    public String createPersonAdressForm(@PathVariable("id") Long id, PersonAdress personAdress, Model model) {
        Person person = personService.findById(id);
        personAdress.setPerson(person);
        model.addAttribute("personAdress", personAdress);
        model.addAttribute("person", person);
        return "adress-create";
    }

    @PostMapping("/adress-create/{id}")
    public String createPersonAdress(@PathVariable("id") Long id, PersonAdress personAdress) {
        Person person = personService.findById(id);
        personAdress.setPerson(person);
        personAdressService.savePersonAdress(personAdress);
        return "redirect:/adress/{id}";
    }

    @GetMapping("/adress/adress-update/{id}")
    public String updatePersonAdressForm(@PathVariable("id") Long id, Model model) {
        PersonAdress personAdress = personAdressService.findById(id);
        Person person = personAdress.getPerson();
        model.addAttribute("personAdress", personAdress);
        model.addAttribute("person", person);
        return "adress-update";
    }

    @PostMapping("/adress-update")
    public String updatePersonAdress(PersonAdress personAdress, RedirectAttributes redirectAttrs) {
        Person person = personAdress.getPerson();
        redirectAttrs.addAttribute("id", person.getId());
        personAdressService.savePersonAdress(personAdress);
        return "redirect:/adress/{id}";

    }

    @GetMapping("/adress/adress-delete/{id}")
    public String deletePerson(@PathVariable("id") Long id, RedirectAttributes redirectAttrs) {
        PersonAdress personAdress = personAdressService.findById(id);
        Person person = personAdress.getPerson();
        redirectAttrs.addAttribute("id", person.getId());
        personAdressService.deleteById(id);
        return "redirect:/adress/{id}";
    }

}
