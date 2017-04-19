package com.animalshelter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;


/**
 * Created by Gavin on 4/4/17.
 */
@Component
public class AnimalRepository {

    @Autowired
    JdbcTemplate template;

    public List<Animal> listAnimals(String name) {
        return template.query("SELECT * FROM animals Where lower(animal_name) " + "Like lower(?) " +
                        "and lower(animal_species) LIKE lower(?) order by animal_id "+"LIMIT 200",
                new Object[] {"%"+name+"%", "%"+name+"%"},
                (rs, i) -> new Animal(
                        rs.getInt("animal_id"),
                        rs.getString("animal_name"),
                        rs.getString("animal_species"),
                        rs.getString("animal_breed"),
                        rs.getString("animal_description")));

        }
     public Animal specificAnimal(Integer id) {
        return template.queryForObject("SELECT * FROM animals Where animal_id=?" ,
                new Object[]{id},
                (rs, i) -> new Animal(
                        rs.getInt("animal_id"),
                        rs.getString("animal_name"),
                        rs.getString("animal_species"),
                        rs.getString("animal_breed"),
                        rs.getString("animal_description")));
    }


        public void SaveAnimal(Animal animal){
        if (animal.getAnimalid() == null){
            template.update("INSERT INTO animals" + "(animal_name,"+ "animal_species,"+ "animal_breed,"+ "animal_description) " +
                            "VALUES (?,?,?,?)",
                    new Object[]{
                    animal.getName(),
                    animal.getSpecies(),
                    animal.getBreed(),
                    animal.getDescription()});
        } else {
            template.update("UPDATE animals SET " + "animal_name = ?," +"animal_species = ?," + "animal_breed = ?," + "animal_description = ?" + "WHERE animal_id = ?",
                    new Object[]{
                            animal.getName(),
                            animal.getSpecies(),
                            animal.getBreed(),
                            animal.getDescription()});
        }
    }
    public void deleteAnimal(Integer Id){
            template.update("DELETE FROM animals WHERE animal_id = ?", Id);
    }
}
