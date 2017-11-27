package fr.unicaen.dez.servlet;

import fr.unicaen.dez.person.PersonDBStub;

public class PersonDB {
    /** Constructeur privé */
    private PersonDB()
    {}

    /** Instance unique non préinitialisée */
    private static PersonDB INSTANCE = null;

    /** Point d'accès pour l'instance unique du singleton */
    public static PersonDBStub getInstance()
    {
        return new PersonDBStub();
    }
}
