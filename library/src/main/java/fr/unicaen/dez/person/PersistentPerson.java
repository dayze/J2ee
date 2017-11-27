package fr.unicaen.dez.person;

public class PersistentPerson extends Person {
    private int id;

    public PersistentPerson(String name, String lastName, int id) {
        super(name, lastName);
        this.id = id;
    }

    public PersistentPerson(String name, String lastName) {
        super(name, lastName);
    }

    public PersistentPerson() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "Prénom: " + this.getName() +
                " Nom: " + this.getLastName();
    }


}
