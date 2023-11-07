package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    Database db;
    FileHandler fileHandler = new FileHandler();
    ArrayList<Superhero> testList = new ArrayList<>();
    File testFile = new File("TestSuperheroData.csv");
    @BeforeEach
    void setUp() {
        db = new Database();
        Superhero superheroTest = new Superhero("abe", "kat", "kaste bananer", 2003, "nej", 12.1);
        Superhero superheroTest2 = new Superhero("troldmand", "john", "kaste ild", 225, "ja", 9001);
        Superhero superheroTest3 = new Superhero("supermand", "kaste frost", 2000, "nej", 12.1);
        testList.add(superheroTest);
        testList.add(superheroTest2);
        testList.add(superheroTest3);
    }

    @Test
    void addSuperhero() {
        int startSize = 3;
        db.addSuperhero("asdasd","asdasd","asdasd",213,"ja",23);
        int expectedSize = startSize + 1;
        int actualSize = db.getSuperheroList().size();

        assertEquals(expectedSize, actualSize);

    }

    @Test
    void searchSuperhero() {
        String expectedName = "troldmand";
        Superhero result = db.searchSuperhero("troldmand");

        assertNotNull(result);

        String actualName = result.getName();

        assertEquals(expectedName, actualName);
    }
    @Test
    void deleteSuperhero(){
        String name = "abe";
        db.deleteSuperhero(name);
        Superhero result = db.searchSuperhero(name);
        assertNull(result);
    }
    @Test
    void editSuperhero() {
        Superhero superheroTest4 = new Superhero("abe", "kat", "kaste bananer", 2003, "nej", 12.1);
        String newName = "monkey";
        db.edit(superheroTest4, newName, "", "", 0, "", 2.2);
        assertEquals(newName, superheroTest4.getName());
        assertEquals("kat", superheroTest4.getRealName());

    }
    @Test
    void loadData(){
        ArrayList<Superhero> loaded = fileHandler.loadData(testFile);
        String actualName = loaded.get(0).getName();
        String expectedName = "test";
        assertEquals(actualName, expectedName);
    }
    @Test
    void sortByName(){
        ArrayList<Superhero> sorted = db.sortByName(testList);
        String actualName = sorted.get(0).getName();
        String expectedName = "abe";
        assertEquals(actualName, expectedName);
    }
    @Test
    void sortByBirthYear(){
        ArrayList<Superhero> sorted = db.sortByBirthYear(testList);
        int actualBirthYear = sorted.get(0).getYearCreated();
        int expectedName = 225;
        assertEquals(actualBirthYear, expectedName);
    }
    @Test
    void sortByPrimarySecondary(){
        ArrayList<Superhero> sorted = db.sortByPrimarySecondary(6,4,testList);//Primary = strength, Secondary = yearCreated.
        int actualYearCreated = sorted.get(0).getYearCreated(); //supermand's yearCreated
        int expectedName = 2000;
        assertEquals(actualYearCreated, expectedName);
    }
}