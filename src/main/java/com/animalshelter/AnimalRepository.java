package com.animalshelter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Gavin on 4/4/17.
 */
@Component
public class AnimalRepository {

    @Autowired
    JdbcTemplate template;

    public List<Animal> listAnimals() {
        ArrayList<Animal> animals = new ArrayList<>();
        return template.query("SELECT * FROM animals ORDER BY animal_id",
                (rs, i) -> new Animal(
                        rs.getInt("animal_id"),
                        rs.getString("animal_name"),
                        rs.getString("animal_species"),
                        rs.getString("animal_breed"),
                        rs.getString("animal_description")));

        }
    public void AddAnimal(Animal animal){
        template.update("INSERT INTO animals" +"(animal_name,"+ "animal_species,"+ " animal_breed,"+ " animal_description) " + "VALUES (?,?,?,?)",
               animal.getName(),
               animal.getSpecies(),
               animal.getBreed(),
               animal.getDescription());

    }
    public void deleteanimal(Integer Id){
        template.update("DELETE FROM animal_name WHERE animal_id = ?" , Id);
        template.update("DELETE FROM animal_species WHERE animal_id = ?" , Id);
        template.update("DELETE FROM animal_breed WHERE animal_id = ?" , Id);
        template.update("DELETE FROM animal_description WHERE animal_id = ?" , Id);
    }


}
