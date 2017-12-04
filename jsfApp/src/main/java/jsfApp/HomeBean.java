package jsfApp;

import fr.unicaen.dez.person.InterfacePersonDB;
import fr.unicaen.dez.person.PersistentPerson;
import fr.unicaen.dez.person.PersonDBStub;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;

@ManagedBean(name = "homeBean")
@SessionScoped
public class HomeBean {
    private InterfacePersonDB personDB = new PersonDBStub();

    public ArrayList<PersistentPerson> getAll() {
       return this.personDB.readAll();
    }
}