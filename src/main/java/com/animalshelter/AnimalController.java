package com.animalshelter;

import com.animalshelter.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

/**
 * Created by Gavin on 4/5/17.
 */
    @Controller
    public class AnimalController {

    @Autowired
    AnimalRepository repo;

    @RequestMapping("/")
    public String home(Model model) {

        model.addAttribute("animals", repo.listAnimals());

        return "index";
    }

    @RequestMapping("/list")
    public String listanimal(Model model) {

        model.addAttribute("animals", repo.listAnimals());

        return "animallist";
    }
    @RequestMapping("/edit")
    public String editanimal(Model model) {

        model.addAttribute("animals", repo.listAnimals());

        return "edit";
    }
    @RequestMapping("/delete")
    public String deleteanimal(Integer animalId){

        // delete this schmuck
        repo.deleteanimal(animalId);

        return "redirect:/";
    }
    @RequestMapping("/saveAnimal")
    public String savePerson(Animal animal){

            repo.AddAnimal(animal);

        return "redirect:/";

    }

}

