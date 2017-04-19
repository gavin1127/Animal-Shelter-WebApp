package com.animalshelter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

/**
 * Created by Gavin on 4/5/17.
 */
    @Controller
    public class AnimalController {

    @Autowired
    AnimalRepository repo;
    @GetMapping("/")
    public String Home(){
        return "index";
    }
    @GetMapping("/list")
    public String listAnimals (Model model, @RequestParam(defaultValue = "") String search){
        model.addAttribute("search", search);
        model.addAttribute("animal", repo.listAnimals(search));
        model.addAttribute("size", repo.listAnimals(search).size());
        return "animallist";

    }
    @GetMapping("/edit")
    public String showAnimalFrom(Model model, Integer animalId){
        if (animalId != null){
            model.addAttribute("animal", repo.specificAnimal(animalId));
        }
        else{
            model.addAttribute("animal", new Animal());
        }
        return "edit";
    }
    @PostMapping("/saveAnimal")
     public String showAnimal(Animal animal){
        repo.SaveAnimal(animal);
        return "/saveAnimal";
       }

}
