import fr.unicaen.dez.person.InterfacePersonDB;
import fr.unicaen.dez.person.PersistentPerson;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HibernatePersonDb implements InterfacePersonDB {
    private SessionFactory sessionFactory;

    public HibernatePersonDb() {
        ServiceRegistry serviceRegistry = null;
        try {
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            serviceRegistry = builder.build();
            this.sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable e) {
            System.out.println("Erreur lors de l'initialisation de la session factory: " + e);
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
            throw e;
        }
    }

    protected void close() throws HibernateException {
        if (this.sessionFactory != null) {
            this.sessionFactory.close();
        }
    }

    @Override
    public boolean create(String name, String lastName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(new PersistentPerson(name, lastName));
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public ArrayList<PersistentPerson> readAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from PersistentPerson");
            ArrayList<PersistentPerson> persons = (ArrayList<PersistentPerson>) query.list();
            transaction.commit();
            return persons;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public PersistentPerson read(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            PersistentPerson persistentPerson = (PersistentPerson) session.get(PersistentPerson.class, id);
            transaction.commit();
            return persistentPerson;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            PersistentPerson persistentPerson = (PersistentPerson) session.load(PersistentPerson.class, id);
            session.delete(persistentPerson);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(int id, String name, String lastName) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            PersistentPerson persistentPerson = (PersistentPerson) session.load(PersistentPerson.class, id);
            persistentPerson.setName(name);
            persistentPerson.setLastName(lastName);
            session.update(persistentPerson);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
}
