package org.example;

import java.util.ArrayList;
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

                    System.out.println("søg efter personen du ville redigere: ");
                    String editInput = keyboard.nextLine();

                    ArrayList<Superhero> editSearchResult = database.searchSuperheroMultiple(editInput);

                    Superhero superheroToBeEdited = null;
                    String name = null;
                    if (editSearchResult.isEmpty()) {
                        System.out.println("Superhelt blev ik fundet");

                    } else if (editSearchResult.size() > 1) {
                        System.out.println("vælg person");
                        int count = 1;
                        for (Superhero superhero : editSearchResult) {
                            System.out.println(count++ + ". " +
                                    superhero.getName() + " " +
                                    superhero.getRealName() + " " +
                                    superhero.getSuperPower() + " " +
                                    superhero.getYearCreated() + " " +
                                    superhero.getIsHuman() + " " +
                                    superhero.getStrength()
                            );
                        }
                        int choice;

                        while (true) {
                            String choiceInput = keyboard.nextLine();

                            try {
                                choice = Integer.parseInt(choiceInput);
                                if (choice >=1 && choice <= database.superheroList.size()) {
                                    break;
                                } else{
                                    System.out.println("Ugyldig valg");
                                }
                            } catch (NumberFormatException numberFormatException ) {
                                System.out.println("Ugyldigt valg");
                            }

                        }
                        superheroToBeEdited = editSearchResult.get(choice - 1);
                    } else {
                        superheroToBeEdited = editSearchResult.get(0); //den første i arraylisten
                    }
                    if (superheroToBeEdited != null) {
                        System.out.println("Rediger superhelt. Tryk Enter hvis du ikke ville ændre værdien.");

                        System.out.println("Navn: " + superheroToBeEdited.getName());
                        String editName = keyboard.nextLine();

                        System.out.println("Rigtige navn: " + superheroToBeEdited.getRealName());
                        String editRealName = keyboard.nextLine();

                        System.out.println("Superkræft: " + superheroToBeEdited.getSuperPower());
                        String editSuperpower = keyboard.nextLine();

                        System.out.println("Fødselsår: " + superheroToBeEdited.getYearCreated());
                        int editBirthYear = 0;
                        while (true) {
                            String inputBirthYear = keyboard.nextLine();
                            try {
                                if (!inputBirthYear.isEmpty()) {
                                    editBirthYear = Integer.parseInt(inputBirthYear);
                                }
                                break;
                            } catch (NumberFormatException n) {
                                System.out.println("du skal skrive et heltal");
                            }
                        }


                        System.out.println("Er din superhelt et menneske? " + superheroToBeEdited.getIsHuman());
                        String editIsHuman = null;
                        String inputIsHuman;
                        do {
                            inputIsHuman = keyboard.nextLine();
                            if (inputIsHuman.toLowerCase().equals("ja")) {
                                editIsHuman = "ja";
                                break;
                            } else if (inputIsHuman.toLowerCase().equals("nej")) {
                                editIsHuman = "nej";
                                break;
                            }else if (!inputIsHuman.isEmpty()) {
                                System.out.println("Du skal skrive (Ja/Nej)");
                            }
                        } while (!inputIsHuman.toLowerCase().equals("ja") && !inputIsHuman.toLowerCase().equals("nej") && !inputIsHuman.isEmpty());

                        System.out.println("Styrke: ");
                        String inputStrength = keyboard.nextLine();
                        double editStrength = 0;
                        while (true){
                            try{
                                if (!inputStrength.isEmpty()){
                                    editStrength = Double.parseDouble(inputStrength);
                                    break;
                                }
                            }catch (NumberFormatException numberFormatException){
                                System.out.println("Du skal skrive et tal!");
                            }
                        }
                        database.edit(superheroToBeEdited, editName, editRealName, editSuperpower, editBirthYear, editIsHuman, editStrength);
                        database.superheroInfo(superheroToBeEdited);
                        System.out.println("Superhelten er redigeret");
                    }



                    break;
                case 5: //delete superhero
                    System.out.println("Skriv navnet på helten du vil slette: ");
                    String superheroToDelete = keyboard.nextLine();
                    database.deleteSuperhero(superheroToDelete);
                    break;
            }

        } while (!(menuInput ==9));}    //tryk 9 for afslut


}


