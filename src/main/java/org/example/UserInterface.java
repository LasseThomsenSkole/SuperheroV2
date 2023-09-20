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
                case 1:
                    database.addSuperhero();

                    break;
                case 2:
                    System.out.println("søg efter en superhelt: ");
                    String singleSearchInput = keyboard.next();
                    Superhero result = database.searchSuperhero(singleSearchInput);
                    if (result != null) {
                        database.superheroInfo(result);
                    }
                    break;
                case 3:
                    System.out.println("søg efter flere superhelte: ");
                    String searchInput = keyboard.next();
                    database.searchSuperheroMultiple(searchInput);
                    break;
                case 4:

                    System.out.println("Hvem vil du redigere? ");
                    database.edit();

                    break;
                case 5:
                    System.out.println("Skriv navnet på helten du vil slette: ");
                    String superheroToDelete = keyboard.nextLine();
                    database.deleteSuperhero(superheroToDelete);
                    break;
            }

        } while (!(menuInput ==9));}


}


