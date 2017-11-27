package fr.unicaen.dez.person;

import java.util.ArrayList;

public class PersonDBStub implements InterfacePersonDB {
    private ArrayList<PersistentPerson> personList;
    private int id = 2;

    public PersonDBStub() {
        this.personList = new ArrayList<>();
        this.initializeData();
    }

    private void initializeData() {
        this.personList.add(new PersistentPerson("Maxime", "Lainé", 0));
        this.personList.add(new PersistentPerson("Jéremy", "Habit", 1));
        this.personList.add(new PersistentPerson("Paul", "Leménager", 2));
    }

    public PersistentPerson read(int id) {
        return this.personList.get(id);
    }

    @Override
    public boolean delete(int id) {
        this.personList.remove(id);
        return true;
    }

    @Override
    public boolean update(int id, String name, String lastName) {
        PersistentPerson persistentPerson = this.personList.get(id);
        persistentPerson.setName(name);
        persistentPerson.setName(lastName);
        return true;
    }

    @Override
    public boolean create(String name, String lastName) {
        this.personList.add(new PersistentPerson(name, lastName, ++this.id));
        return true;
    }

    public ArrayList<PersistentPerson> readAll() {
        return this.personList;
    }
}
