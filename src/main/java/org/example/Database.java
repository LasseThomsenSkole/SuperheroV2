package org.example;
import java.util.ArrayList;
import java.util.Objects;

public class Database {
    private ArrayList<Superhero> superheroList;

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


    //search that can return more than 1 superhero
    public ArrayList<Superhero> searchSuperheroMultiple(String search) {
        ArrayList<Superhero> searchResult = new ArrayList<>();

        for (Superhero superhero : superheroList) {
            if (superhero.getName().contains(search)) { //if superheroName contains some of the chars in the search string
                searchResult.add(superhero);
            }
        }
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
            if (!(birthYear == 0)){
                superheroToBeEdited.setYearCreated(birthYear);
            }
            if(!(isHuman == null)){
                superheroToBeEdited.setIsHuman(isHuman);
            }
            if(!(strength == 0)){
                superheroToBeEdited.setStrength(strength);
            }

        }
    }
    public String superheroInfo(Superhero superhero) {
        System.out.println("Superheltens navn: " + superhero.getName());
        if (superhero.getRealName() != null) {
            return  "Superheltens navn: " + superhero.getName()
                    + "\n"
                    + "Superheltens rigtige navn: " + superhero.getRealName()
                    + "\n"
                    + "Superheltens superkræft: " + superhero.getSuperPower()
                    + "\n"
                    + "Superheltens fødselsår: " + superhero.getYearCreated()
                    + "\n"
                    + "Er superhelten menneske?  " + superhero.getIsHuman()
                    + "\n"
                    + "Superheltens styrke:  " + superhero.getStrength()
                    + "\n";
        }else {
            return  "Superheltens navn: " + superhero.getName()
                    + "\n"
                    + "Superheltens superkræft: " + superhero.getSuperPower()
                    + "\n"
                    + "Superheltens fødselsår: " + superhero.getYearCreated()
                    + "\n"
                    + "Er superhelten menneske?  " + superhero.getIsHuman()
                    + "\n"
                    + "Superheltens styrke:  " + superhero.getStrength()
                    + "\n";
        }
    }

    public void deleteSuperhero(String name) {
        superheroList.removeIf(superhero -> Objects.equals(superhero.getName(), name));
    }

    public ArrayList<Superhero> getSuperheroList() {
        return superheroList;
    }
}

