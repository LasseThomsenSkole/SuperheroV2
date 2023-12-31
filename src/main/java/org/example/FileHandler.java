package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private final String FILE_NAME = "SuperheroData.csv";
    private final File file = new File(FILE_NAME);

    public ArrayList<Superhero> loadData(File file){
        ArrayList<Superhero> tempSuperhero = new ArrayList<>();
        Scanner scan;
        try {
            scan = new Scanner(file);
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
            scan.close(); // close scanner
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return tempSuperhero;
    }

    public void saveData(ArrayList<Superhero> superheroList) {

        if (lastSuperheroCheck(superheroList)){ //check if the file has already been saved
            try {
                PrintStream printStream = new PrintStream(FILE_NAME);
                for (Superhero superhero : superheroList) {
                    printStream.print(toCsv(superhero));
                }
                printStream.close(); //close the printStream
            } catch (FileNotFoundException e) {
                System.out.println("fil ikke fundet");
            }
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
    public String getLastLine() {
        Scanner scanner;
        String lastLine;
        try {
            scanner = new Scanner(file);
            lastLine = null;
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                lastLine = scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return lastLine;
    }

    public File getFile() {
        return file;
    }

    public boolean lastSuperheroCheck(ArrayList<Superhero> superheroesList){
        String[] superheroCsv = getLastLine().split(";");

        String superheroListName = superheroesList.get((superheroesList.size()) - 1).getName();
        String superheroListSuperpower = superheroesList.get((superheroesList.size()) -1).getSuperPower();
        String superheroCsvName = superheroCsv[0];
        String superheroCsvSuperpower = superheroCsv[2];

        //return true if last superhero from csv is the same as the last superhero of the arraylist
        return superheroListName.equals(superheroCsvName) && superheroListSuperpower.equals(superheroCsvSuperpower);
    }
}
