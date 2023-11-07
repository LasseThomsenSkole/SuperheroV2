package org.example;

import java.util.Comparator;

public class StrengthComparator implements Comparator<Superhero> {
    public int compare(Superhero superhero1, Superhero superhero2) {
        return Double.compare(superhero1.getStrength(), superhero2.getStrength());
    }
}
