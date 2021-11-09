package com.barlognax.controller;

import com.barlognax.model.Person;
import com.barlognax.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping("/persons")
    public String findAll(Model model) {
        List<Person> personList = personService.findAll();
        model.addAttribute("persons", personList);
        return "person-list";
    }

    @GetMapping("/person-create")
    public String createPersonForm(Person person) {
        return "person-create";
    }

    @PostMapping("/person-create")
    public String createPerson(@Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "person-create";
        }
        personService.savePerson(person);
        return "redirect:/persons";
    }

    @GetMapping("/person-delete/{id}")
    public String deletePerson(@PathVariable("id") Long id) {
        personService.deleteById(id);
        return "redirect:/persons";
    }

    @GetMapping("/person-update/{id}")
    public String updatePersonForm(@PathVariable("id") Long id, Model model) {
        Person person = personService.findById(id);
        model.addAttribute("person", person);
        return "person-update";
    }

    @PostMapping("/person-update")
    public String updatePerson(@Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "person-update";
        }
        personService.savePerson(person);
        return "redirect:/persons";
    }
}
