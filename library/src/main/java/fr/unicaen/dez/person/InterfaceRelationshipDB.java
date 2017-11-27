package fr.unicaen.dez.person;

import java.sql.SQLException;
import java.util.ArrayList;

public interface InterfaceRelationshipDB {
    boolean create(int firstPerson, int secondPerson, String type);
    ArrayList<PersistentRelationship> readAll();
    PersistentRelationship read(int id) throws SQLException;
    boolean delete(int id);
    boolean update(int id, int firstPerson, int secondPerson, String type) throws SQLException;
}
