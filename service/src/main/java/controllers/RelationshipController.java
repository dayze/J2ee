package controllers;

import fr.unicaen.dez.person.InterfacePersonDB;
import fr.unicaen.dez.person.InterfaceRelationshipDB;
import fr.unicaen.dez.person.PersistentPerson;
import fr.unicaen.dez.person.PersistentRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class RelationshipController {
    @Autowired
    private InterfaceRelationshipDB interfaceRelationshipDB;

    @RequestMapping(value = "relation/{id}", method = RequestMethod.GET)
    public PersistentRelationship getRelationshipId(@PathVariable("id") int id) throws SQLException {
        return interfaceRelationshipDB.read(id);
    }

    @RequestMapping(value = "relation", method = RequestMethod.GET)
    public ArrayList<PersistentRelationship> getRelationshipAll() {
        return interfaceRelationshipDB.readAll();
    }

    @RequestMapping(value = "relation/update/{id}", method = RequestMethod.POST)
    public boolean updateRelationshipId(@PathVariable("id") int id,
                                        @RequestParam("firstPerson") int firstPerson,
                                        @RequestParam("secondPerson") int secondPerson,
                                        @RequestParam("type") String type) throws SQLException {
        return interfaceRelationshipDB.update(id, firstPerson, secondPerson, type);
    }

    @RequestMapping(value = "relation/{id}", method = RequestMethod.DELETE)
    public boolean deleteRelationshipId(@PathVariable("id") int id) {
        return interfaceRelationshipDB.delete(id);
    }

    @RequestMapping(value = "relation", method = RequestMethod.POST)
    public boolean createRelationshipId(@RequestParam("firstPerson") int firstPerson,
                                        @RequestParam("secondPerson") int secondPerson,
                                        @RequestParam("type") String type) {
        return this.interfaceRelationshipDB.create(firstPerson, secondPerson, type);
    }

}
