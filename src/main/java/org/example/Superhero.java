package org.example;

public class Superhero {

    //Attributes
    private String name;
    private String superPower;
    private int yearCreated;
    private String isHuman;
    private double strength;
    private String realName;

    //Constructor with real name
    public Superhero(String name, String realName, String superPower, int yearCreated, String isHuman, double strength) {
        this.name = name;
        this.realName = realName;
        this.superPower = superPower;
        this.yearCreated = yearCreated;
        this.isHuman = isHuman;
        this.strength = strength;
    }

    //Constructor without real name
    public Superhero(String name, String superPower, int yearCreated, String isHuman, double strength) {
        this.name = name;
        this.superPower = superPower;
        this.yearCreated = yearCreated;
        this.isHuman = isHuman;
        this.strength = strength;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    public void setIsHuman(String isHuman) {
        this.isHuman = isHuman;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }

    public String getSuperPower() {
        return superPower;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public String getIsHuman() {
        return isHuman;
    }

    public double getStrength() {
        return strength;
    }

    //Output of superhero
    public String toString() {
        if (getRealName() == null){
            return "Superhero{" +
                    "name='" + name + '\''  +
                    ", superPower='" + superPower + '\'' +
                    ", yearCreated=" + yearCreated +
                    ", isHuman=" + isHuman +
                    ", strength=" + strength +
                    '}' + "\n";
        }else {
            return "Superhero{" +
                    "name='" + name + '\'' +
                    ", realName='" + realName + '\'' +
                    ", superPower='" + superPower + '\'' +
                    ", yearCreated=" + yearCreated +
                    ", isHuman=" + isHuman +
                    ", strength=" + strength +
                    '}' + "\n";
        }
    }

}
