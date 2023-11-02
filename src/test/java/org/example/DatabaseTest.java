package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    Database db;
    Superhero superheroTest4 = new Superhero("abe", "kat", "kaste bananer", 2003, "nej", 12.1);

    @BeforeEach
    void setUp() {
        db = new Database();
        Superhero superheroTest = new Superhero("abe", "kat", "kaste bananer", 2003, "nej", 12.1);
        Superhero superheroTest2 = new Superhero("troldmand", "john", "kaste ild", 225, "ja", 9001);
        Superhero superheroTest3 = new Superhero("supermand", "kaste frost", 2000, "nej", 12.1);
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
    void editSuperhero(){
        String newName = "monkey";
        db.edit(superheroTest4, newName,"","",0,"",2.2);
        assertEquals(newName, superheroTest4.getName());
        assertEquals("kat", superheroTest4.getRealName());

    }
}