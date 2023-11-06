package org.example;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private final String FILE_NAME = "SuperheroData.csv";
    public ArrayList<Superhero> loadData(){
        ArrayList<Superhero> tempSuperhero = new ArrayList<>();
        Scanner scan = new Scanner(FILE_NAME);
        String name;
        String realName;
        String superpower;
        int birthYear;
        String isHuman;
        double strength;
        while(scan.hasNextLine()) {
            String[] superheroCsv = scan.nextLine().split(";");
            name = superheroCsv[0];
            realName = superheroCsv[1];
            superpower = superheroCsv[2];
            birthYear = Integer.parseInt(superheroCsv[3]);
            isHuman = superheroCsv[4];
            strength = Double.parseDouble(superheroCsv[5]);

            tempSuperhero.add(new Superhero(name, realName, superpower, birthYear, isHuman, strength));

        }
        return tempSuperhero;
    }

    public void saveData(ArrayList<Superhero> superheroList) {
        try {
            PrintStream printStream = new PrintStream(FILE_NAME);
            for (Superhero superhero : superheroList) {
                printStream.print(toCsv(superhero));
            }
        } catch (FileNotFoundException e) {
            System.out.println("fil ikke fundet");
        }
    }
    public String toCsv(Superhero superhero){
        if (superhero.getRealName() == null){
            return superhero.getName() + ';'  +
                    "null" + ';' +
                    superhero.getSuperPower() + ';' +
                    superhero.getYearCreated() + ';' +
                    superhero.getIsHuman() + ';' +
                    superhero.getStrength() + ';' +
                    "\n";
        }else {
            return  superhero.getName() + ';' +
                    superhero.getRealName() + ';' +
                    superhero.getSuperPower() + ';' +
                    superhero.getYearCreated() + ';' +
                    superhero.getIsHuman() + ';' +
                    superhero.getStrength() +
                    "\n";
        }
    }
}
