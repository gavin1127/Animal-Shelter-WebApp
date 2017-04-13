package com.animalshelter;

import com.animalshelter.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Gavin on 4/5/17.
 */
    @Controller
    public class AnimalController {

        @Autowired
        AnimalRepository repo;

        @RequestMapping("/")
        public String listPeople(Model model){

            model.addAttribute("animals", repo.listAnimals());

            return "index";
        }
    }

