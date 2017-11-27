package fr.unicaen.dez.person;

public class Relationship {
    private int firstPerson;
    private int secondPerson;
    private String type;

    public Relationship(int firstPerson, int secondPerson, String type) {
        this.firstPerson = firstPerson;
        this.secondPerson = secondPerson;
        this.type = type;
    }

    public Relationship(){}

    public int getFirstPerson() {
        return firstPerson;
    }

    public void setFirstPerson(int firstPerson) {
        this.firstPerson = firstPerson;
    }

    public int getSecondPerson() {
        return secondPerson;
    }

    public void setSecondPerson(int secondPerson) {
        this.secondPerson = secondPerson;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
