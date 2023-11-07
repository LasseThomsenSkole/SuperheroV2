package org.example;

import java.util.ArrayList;

public class Controller {
    Database db = new Database();


    public void addSuperhero(String superName, String realName, String superpower, int birthYear,String isHuman, double strength){
        db.addSuperhero(superName,realName,superpower,birthYear,isHuman,strength);
    }

    public Superhero searchSuperhero(String searchInput){
        return db.searchSuperhero(searchInput);
    }

    public ArrayList<Superhero> searchSuperheroMultiple(String searchInput){
        return db.searchSuperheroMultiple(searchInput);
    }

    public void edit(Superhero superheroToBeEdited, String name, String realName,String superpower, int birthYear, String isHuman, double strength){
        db.edit(superheroToBeEdited, name, realName, superpower, birthYear, isHuman, strength);
    }

    public String superheroInfo(Superhero superhero){
        return db.superheroInfo(superhero);
    }

    public void deleteSuperhero(String name){
        db.deleteSuperhero(name);
    }

    public ArrayList<Superhero> getSuperheroList(){
        return db.getSuperheroList();
    }
    public void saveData(){
        db.saveData();
    }
    public void loadData(){
        db.loadData();
    }

}
