package com.animalshelter; /**
 * Created by Gavin on 3/29/17.
 */
public class Animal {
    int Id;
    String Name;
    String Species;
    String Breed;
    String Description;

    public Animal(Integer Id, String Name, String Species, String Breed, String Description) {
        this.Id = Id;
        this.Name = Name;
        this.Species = Species;
        this.Breed = Breed;
        this.Description = Description;
    }

    public Animal() {

    }

    public Integer getAnimalid(){return Id;}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSpecies() {
        return Species;
    }

    public void setSpecies(String species) {
        Species = species;
    }

    public String getBreed() {
        return Breed;
    }

    public void setBreed(String breed) {
        Breed = breed;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

}
