package org.example;

import java.util.Scanner;

public class UserInterface {
    public UserInterface(){
    }

    public void startprogram(){
        //menu input
        Scanner keyboard = new Scanner(System.in);
        int menuInput;
        Database database = new Database();

        //programloop
        do {
            System.out.println("1. opret 2. find en helt 3. find flere helte 4. Rediger en superhelt 5. Slet en superhelt 9. afslut");
            menuInput = keyboard.nextInt();
            switch (menuInput) {
                case 1: //add superhero
                    System.out.println("Indtast kaldenavn");
                    String superName = keyboard.next();

                    System.out.println("Indtast rigtige navn");
                    String realName = keyboard.next();

                    System.out.println("Indtast superkræft");
                    String superpower = keyboard.next();

                    System.out.println("Indtast fødselsår");
                    //Input mismatch håndtering
                    while (!keyboard.hasNextInt()) {
                        System.out.println("du skal skrive et hel tal: ");
                        keyboard.next();
                    }
                    int birthYear = keyboard.nextInt();

                    String isHuman = null;
                    while (isHuman == null) {
                        System.out.println("Er din superhelt et menneske? [ja/nej]");

                        String erMenneskeInput = keyboard.next();

                        if (erMenneskeInput.equals("ja")) {
                            isHuman = "er menneske";
                        } else if (erMenneskeInput.equals("nej")) {
                            isHuman = "er ikke menneske";

                        }
                    }

                    double strength;
                    System.out.println("Indtast styrketal");
                    while (!keyboard.hasNextDouble()) {
                        System.out.println("du skal angive et tal:");
                        keyboard.next();
                    }
                    strength = keyboard.nextDouble();

                    database.addSuperhero(superName, realName, superpower, birthYear, isHuman, strength);

                    System.out.println(database.searchSuperhero(superName) + " blev oprettet");

                    break;
                case 2: //search for superhero
                    System.out.println("søg efter en superhelt: ");
                    String singleSearchInput = keyboard.next();
                    Superhero result = database.searchSuperhero(singleSearchInput);
                    if (result != null) {
                        System.out.println("Søgning: ");
                        database.superheroInfo(result);
                    }else {
                        System.out.println("Superhelten blev ikke fundet");
                    }
                    break;
                case 3: //search multiple superheroes
                    System.out.println("søg efter flere superhelte: ");
                    String searchInput = keyboard.next();
                    System.out.println(database.searchSuperheroMultiple(searchInput));
                    break;
                case 4: //edit superhero

                    System.out.println("Hvem vil du redigere? ");
                    database.edit();


                    break;
                case 5: //delete superhero
                    System.out.println("Skriv navnet på helten du vil slette: ");
                    String superheroToDelete = keyboard.nextLine();
                    database.deleteSuperhero(superheroToDelete);
                    break;
            }

        } while (!(menuInput ==9));}    //tryk 9 for afslut


}


