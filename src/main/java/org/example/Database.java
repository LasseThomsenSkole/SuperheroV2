package org.example;
import java.io.File;
import java.util.*;

public class Database {
    private ArrayList<Superhero> superheroList;
    //private final File file = new File("SuperheroData.csv");
    FileHandler fileHandler = new FileHandler();

    //Superheroes which are already on the list
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

    //Add Superhero into the list
    public void addSuperhero(String superName, String realName, String superpower, int birthYear, String isHuman, double strength) {
        //add superhelten til arrayListen
        superheroList.add(new Superhero(superName, realName, superpower, birthYear, isHuman, strength));

    }

    //Search for the one superhero by input
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

    //Search that can return more than 1 superhero
    public ArrayList<Superhero> searchSuperheroMultiple(String search) {
        ArrayList<Superhero> searchResult = new ArrayList<>();

        for (Superhero superhero : superheroList) {
            if (superhero.getName().contains(search)) { //if superheroName contains some of the chars in the search string
                searchResult.add(superhero);
            }
        }
        return searchResult;
    }

    //Edit the superhero of choice
    public void edit(Superhero superheroToBeEdited, String name, String realName, String superpower, int birthYear, String isHuman, double strength) {
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
            if (!(birthYear == 0)) {
                superheroToBeEdited.setYearCreated(birthYear);
            }
            if (!(isHuman == null)) {
                superheroToBeEdited.setIsHuman(isHuman);
            }
            if (!(strength == 0)) {
                superheroToBeEdited.setStrength(strength);
            }

        }
    }

    //Get the info of one superhero by real name
    public String superheroInfo(Superhero superhero) {
        if (superhero.getRealName() != null) {
            return "Superheltens navn: " + superhero.getName()
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
        } else {
            return "Superheltens navn: " + superhero.getName()
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

    //Delete the superhero of choice
    public void deleteSuperhero(String name) {
        superheroList.removeIf(superhero -> Objects.equals(superhero.getName(), name));
    }

    //Return the Arraylist
    public ArrayList<Superhero> getSuperheroList() {
        return superheroList;
    }

    //load the file into the program
    public void loadData(){
        superheroList = fileHandler.loadData(fileHandler.getFile());
    }

    //Save the new superheroes from the program into the file
    public void saveData(ArrayList<Superhero> superheroList){
        fileHandler.saveData(superheroList);
    }

    //Sort methods
    public ArrayList<Superhero> sortByName(){
        ArrayList<Superhero> sortedList = new ArrayList<>();
        sortedList.addAll(superheroList);
        Collections.sort(sortedList, new NameComparator());
        return sortedList;
    }
    public ArrayList<Superhero> sortByRealName(){
        ArrayList<Superhero> sortedList = new ArrayList<>();
        sortedList.addAll(superheroList);
        Collections.sort(sortedList, new RealNameComparator());
        return sortedList;
    }
    public ArrayList<Superhero> sortBySuperpower(){
        ArrayList<Superhero> sortedList = new ArrayList<>();
        sortedList.addAll(superheroList);
        Collections.sort(sortedList, new SuperPowerComparator());
        return sortedList;
    }
    public ArrayList<Superhero> sortByBirthYear(){
        ArrayList<Superhero> sortedList = new ArrayList<>();
        sortedList.addAll(superheroList);
        Collections.sort(sortedList, new BirthYearComparator());
        return sortedList;
    }
    public ArrayList<Superhero> sortByIsHuman(){
        ArrayList<Superhero> sortedList = new ArrayList<>();
        sortedList.addAll(superheroList);
        Collections.sort(sortedList, new IsHumanComparator());
        return sortedList;
    }
    public ArrayList<Superhero> sortByStrength(){
        ArrayList<Superhero> sortedList = new ArrayList<>();
        sortedList.addAll(superheroList);
        Collections.sort(sortedList, new StrengthComparator());
        return sortedList;
    }

    public ArrayList<Superhero> sortByPrimarySecondary(int a, int b){
        ArrayList<Superhero> sortedList = new ArrayList<>();
        sortedList.addAll(superheroList);

        Comparator<Superhero> comparator1 = null;
        Comparator<Superhero> comparator2 = null;

        switch (a){
            case 1 -> comparator1 = new NameComparator();
            case 2 -> comparator1 = new RealNameComparator();
            case 3 -> comparator1 = new SuperPowerComparator();
            case 4 -> comparator1 = new BirthYearComparator();
            case 5 -> comparator1 = new IsHumanComparator();
            case 6 -> comparator1 = new StrengthComparator();
        }

        switch (b) {
            case 1 -> comparator2 = new NameComparator();
            case 2 -> comparator2 = new RealNameComparator();
            case 3 -> comparator2 = new SuperPowerComparator();
            case 4 -> comparator2 = new BirthYearComparator();
            case 5 -> comparator2 = new IsHumanComparator();
            case 6 -> comparator2 = new StrengthComparator();
        }


        if(!comparator1.getClass().equals(comparator2.getClass())) {
            Collections.sort(sortedList, comparator1.thenComparing(comparator2));
        }
            else{
                throw new IllegalArgumentException();
            }
        return sortedList;
        }
}


