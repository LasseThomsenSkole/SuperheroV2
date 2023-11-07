package org.example;

import java.util.Comparator;

public class BirthYearComparator implements Comparator<Superhero> {
    public int compare(Superhero superhero1, Superhero superhero2) {
        return Integer.compare(superhero1.getYearCreated(), superhero2.getYearCreated());
    }
}
