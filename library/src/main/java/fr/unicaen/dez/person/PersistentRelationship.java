package fr.unicaen.dez.person;

public class PersistentRelationship extends Relationship {
    private int id;

    public PersistentRelationship(int firstPerson, int secondPerson, String type, int id) {
        super(firstPerson, secondPerson, type);
        this.id = id;
    }

    public PersistentRelationship(int firstPerson, int secondPerson, String type) {
        super(firstPerson, secondPerson, type);
    }

    public int getId() {
        return id;
    }
}
