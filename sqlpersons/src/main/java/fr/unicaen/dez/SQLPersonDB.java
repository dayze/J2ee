package fr.unicaen.dez;

import fr.unicaen.dez.person.InterfacePersonDB;
import fr.unicaen.dez.person.PersistentPerson;

import java.sql.*;
import java.util.ArrayList;

public class SQLPersonDB implements InterfacePersonDB {

    private Connection connection;

    public SQLPersonDB(Connection connection) {
        this.connection = connection;
    }

    public boolean create(String name, String lastName) {
        try {
            PreparedStatement s = connection.prepareStatement("INSERT INTO personne (name, lastname) VALUES (?, ?)");
            s.setString(1, name);
            s.setString(2, lastName);
            s.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<PersistentPerson> readAll() {
        ArrayList<PersistentPerson> persistentPerson = new ArrayList<>();
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * from personne");
            while (rs.next()) {
                persistentPerson.add(new PersistentPerson(
                        rs.getString("name"),
                        rs.getString("lastName"),
                        rs.getInt("id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persistentPerson;
    }

    public PersistentPerson read(int id) throws SQLException {
        PersistentPerson persistentPerson = null;
        try {
            PreparedStatement s = connection.prepareStatement("SELECT * from personne where id= ?");
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                persistentPerson = new PersistentPerson(
                        rs.getString("name"),
                        rs.getString("lastName"),
                        rs.getInt("id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persistentPerson;
    }

    public boolean delete(int id) {
        PersistentPerson persistentPerson = null;
        try {
            PreparedStatement s = connection.prepareStatement("DELETE from personne where id= ?");
            s.setInt(1, id);
            s.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(int id, String name, String lastName) {
        try {
            PreparedStatement s = connection.prepareStatement("UPDATE personne SET name = ?, lastName = ? where id= ?");
            s.setString(1, name);
            s.setString(2, lastName);
            s.setInt(3, id);
            s.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
