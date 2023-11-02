package org.example;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Database {
    ArrayList<Superhero> superheroList;
    Scanner keyboard = new Scanner(System.in);
    Superhero superheroToBeEdited = null;

    public Database() {

        superheroList = new ArrayList<>();

        //dummy superheroes
        Superhero superheroTest = new Superhero("abe", "kat", "kaste bananer", 2003, "nej", 12.1);
        Superhero superheroTest2 = new Superhero("troldmand", "john", "kaste ild", 225, "ja", 9001);
        Superhero superheroTest3 = new Superhero("supermand", "kaste frost", 2000, "nej", 12.1);
        superheroList.add(superheroTest);
        superheroList.add(superheroTest2);
        superheroList.add(superheroTest3);


    }

    public void addSuperhero(String superName, String realName, String superpower, int birthYear,String isHuman, double strength) {

        //add superhelten til arrayListen
        superheroList.add(new Superhero(superName, realName, superpower, birthYear, isHuman, strength));




    }

    public Superhero searchSuperhero(String searchInput) {

        ArrayList<String> heroes = new ArrayList<>();



        //foreach loop som sammenligner søgning med superheroes på superheroList
        for (Superhero superhero : superheroList) {

            if (superhero.getName().toLowerCase().contains(searchInput.toLowerCase())) {
                if (!heroes.contains(superhero.getName())) {
                    heroes.add(superhero.getName());

                    return superhero;

                }
            }
        }
        return null;
    }


    //søgning hvor flere resultater kommer tilbage
    public ArrayList<Superhero> searchSuperheroMultiple(String search) {
        ArrayList<Superhero> searchResult = new ArrayList<>();


        for (Superhero superhero : superheroList) {
            if (superhero.getName().contains(search)) {
                searchResult.add(superhero);
            }
        }
        //System.out.println(searchResult);
        return searchResult;
    }


    public void edit(Superhero superheroToBeEdited, String name, String realName,String superpower, int birthYear, String isHuman, double strength) {
        // if name is empty then don't set.
        if (superheroToBeEdited != null) {

            if (!name.isEmpty()) {
                superheroToBeEdited.setName(name);
            }
            if (!realName.isEmpty()) {
                superheroToBeEdited.setRealName(realName);
            }
            if (!superpower.isEmpty()) {
                superheroToBeEdited.setSuperPower(superpower);
            }

            //System.out.println("Fødselsår: " + superheroToBeEdited.getYearCreated());
            if (!(birthYear == 0)){
                superheroToBeEdited.setYearCreated(birthYear);
            }


            //System.out.println("Er superhelten menneske? " + superheroToBeEdited.getIsHuman());

            if(!isHuman.isEmpty()){
                superheroToBeEdited.setIsHuman(isHuman);
            }

            //System.out.println("Superheltens styrketal: " + superheroToBeEdited.getStrength());
            if(!(strength == 0)){
                superheroToBeEdited.setStrength(strength);
            }

        }
    }

    public void superheroInfo(Superhero superhero) {
        System.out.println("Superheltens navn: " + superhero.getName());
        if (superhero.getRealName() != null) {
            System.out.println("Superheltens rigtige navn: " + superhero.getRealName());
        }
        System.out.println("Superheltens superkræft: " + superhero.getSuperPower());
        System.out.println("Superheltens fødselsår: " + superhero.getYearCreated());
        System.out.println("Er superhelten menneske?  " + superhero.getIsHuman());
        System.out.println("Superheltens styrke:  " + superhero.getStrength());
    }

    public void deleteSuperhero(String name) {
        superheroList.removeIf(superhero -> Objects.equals(superhero.getName(), name));

    }

    public ArrayList<Superhero> getSuperheroList() {
        return superheroList;
    }
}

