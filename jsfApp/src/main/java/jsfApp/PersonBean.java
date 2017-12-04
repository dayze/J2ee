package jsfApp;

import fr.unicaen.dez.person.InterfacePersonDB;
import fr.unicaen.dez.person.PersistentPerson;
import fr.unicaen.dez.person.PersonDBStub;
import hibernate.HibernatePersonDb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.sql.SQLException;

@ManagedBean(name = "personBean")
@RequestScoped
public class PersonBean {
    @ManagedProperty(value = "#{param.id}")
    private int personId;
    private InterfacePersonDB personDB = new HibernatePersonDb();

    public String getName() throws SQLException {
        return this.personDB.read(this.personId).getName();
    }

    public String getLastName() throws SQLException {
        return this.personDB.read(this.personId).getLastName();
    }


    public void setPersonId(int personId) {
        this.personId = personId;
    }
}