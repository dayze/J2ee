package fr.unicaen.dez.person;

import java.sql.SQLException;
import java.util.ArrayList;

public interface InterfacePersonDB {
    public boolean create(String name, String lastName);
    public ArrayList<PersistentPerson> readAll();
    public PersistentPerson read(int id) throws SQLException;
    public boolean delete(int id);
    public boolean update(int id, String name, String lastName) throws SQLException;
}
