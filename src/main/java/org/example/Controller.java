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
   public ArrayList<Superhero> sortByName(ArrayList<Superhero> superheroList){
        return db.sortByName(superheroList);
   }
   public ArrayList<Superhero> sortByRealname(ArrayList<Superhero> superheroList){
        return db.sortByRealName(superheroList);
   }
   public ArrayList<Superhero> sortBySuperpower(ArrayList<Superhero> superheroList){
        return db.sortBySuperpower(superheroList);
   }
   public ArrayList<Superhero> sortByBirthYear(ArrayList<Superhero> superheroList){
        return db.sortByBirthYear(superheroList);
   }
   public ArrayList<Superhero> sortByIsHuman(ArrayList<Superhero> superheroList){
        return db.sortByIsHuman(superheroList);
   }
   public ArrayList<Superhero> sortByStrength(ArrayList<Superhero> superheroList){
        return db.sortByStrength(superheroList);
   }

   public ArrayList<Superhero> sortByPrimarySecondary(int a, int b,ArrayList<Superhero> superheroList){
        return db.sortByPrimarySecondary(a,b,superheroList);
   }

}
