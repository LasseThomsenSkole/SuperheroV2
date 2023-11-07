package org.example;

import java.util.Comparator;

public class IsHumanComparator implements Comparator<Superhero> {
    public int compare(Superhero superhero1, Superhero superhero2) {
        return String.CASE_INSENSITIVE_ORDER.compare(superhero1.getIsHuman(), superhero2.getIsHuman());
    }
}
