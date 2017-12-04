package controllers;

import fr.unicaen.dez.person.InterfacePersonDB;
import fr.unicaen.dez.person.PersistentPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class PersonController {
    @Autowired
    private InterfacePersonDB interfacePersonDB;

    @RequestMapping(value = "person/{id}", method = RequestMethod.GET)
    public PersistentPerson getPersonId(@PathVariable("id") int id) throws SQLException {
        return interfacePersonDB.read(id);
    }

    @RequestMapping(value = "person", method = RequestMethod.GET)
    public ArrayList<PersistentPerson> getPersonAll() {
        return interfacePersonDB.readAll();
    }

    @RequestMapping(value = "person/update/{id}", method = RequestMethod.POST)
    public boolean updatePersonId(@PathVariable("id") int id, @RequestParam("name") String name, @RequestParam("lastName") String lastName) throws SQLException {
        return interfacePersonDB.update(id, name, lastName);
    }

    @RequestMapping(value = "person/{id}", method = RequestMethod.DELETE)
    public boolean deletePersonId(@PathVariable("id") int id) {
        return interfacePersonDB.delete(id);
    }

    @RequestMapping(value = "person", method = RequestMethod.POST)
    public boolean createPerson(@RequestParam("name") String name, @RequestParam("lastName") String lastName) {
        return this.interfacePersonDB.create(name, lastName);
    }

}
