package jsfApp;

import fr.unicaen.dez.person.InterfacePersonDB;
import fr.unicaen.dez.person.PersistentPerson;
import fr.unicaen.dez.person.PersonDBStub;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.sql.SQLException;
import java.util.ArrayList;

@ManagedBean(name = "personBean")
@RequestScoped
public class PersonBean {
    @ManagedProperty(value = "#{param.id}")
    private int personId;
    private InterfacePersonDB personDB = new PersonDBStub();

    public String getMessage() throws SQLException {
        return "Bonjour " + this.personDB.read(this.personId).getName() + " " + this.personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}