/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistQueuedemo;

/**
 *
 * @author cadelmonterde
 */
public class Pet {
    private String name;
    private String species;
    
    public Pet(String name,String species)
    {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return name.toString()+" its a "+species.toString()+"!!!!";
    }
    
    
}
