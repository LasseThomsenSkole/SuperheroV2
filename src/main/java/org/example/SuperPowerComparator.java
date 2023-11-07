package org.example;

import java.util.Comparator;

public class SuperPowerComparator implements Comparator<Superhero> {
    public int compare(Superhero superhero1, Superhero superhero2) {
        return String.CASE_INSENSITIVE_ORDER.compare(superhero1.getSuperPower(), superhero2.getSuperPower());
    }
}
