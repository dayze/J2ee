package jsfApp;

import fr.unicaen.dez.person.InterfacePersonDB;
import fr.unicaen.dez.person.PersistentPerson;
import fr.unicaen.dez.person.PersonDBStub;
import hibernate.HibernatePersonDb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;

@ManagedBean(name = "homeBean")
@SessionScoped
public class HomeBean {
    private InterfacePersonDB personDB = new HibernatePersonDb();

    public ArrayList<PersistentPerson> getAll() {
       return this.personDB.readAll();
    }
}