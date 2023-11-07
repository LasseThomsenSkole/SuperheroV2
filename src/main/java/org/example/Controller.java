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
    public void saveData(ArrayList<Superhero> superheroList){
        db.saveData(superheroList);
    }
    public void loadData(){
        db.loadData();
    }
   public ArrayList<Superhero> sortByName(){
        return db.sortByName();
   }
   public ArrayList<Superhero> sortByRealname(){
        return db.sortByRealName();
   }
   public ArrayList<Superhero> sortBySuperpower(){
        return db.sortBySuperpower();
   }
   public ArrayList<Superhero> sortByBirthYear(){
        return db.sortByBirthYear();
   }
   public ArrayList<Superhero> sortByIsHuman(){
        return db.sortByIsHuman();
   }
   public ArrayList<Superhero> sortByStrength(){
        return db.sortByStrength();
   }

   public ArrayList<Superhero> sortByPrimarySecondary(int a, int b){
        return db.sortByPrimarySecondary(a,b);
   }

   // String name, String realName, String superPower, int yearCreated, String isHuman, double strength
}
