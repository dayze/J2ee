package hibernate;

import fr.unicaen.dez.person.InterfaceRelationshipDB;
import fr.unicaen.dez.person.PersistentRelationship;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.SQLException;
import java.util.ArrayList;

public class HibernateRelationshipDb implements InterfaceRelationshipDB {
    private SessionFactory sessionFactory;

    public HibernateRelationshipDb() {
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
    public boolean create(int firstPerson, int secondPerson, String type) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(new PersistentRelationship(firstPerson, secondPerson, type));
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
    public ArrayList<PersistentRelationship> readAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from PersistentRelationship");
            ArrayList<PersistentRelationship> relations = (ArrayList<PersistentRelationship>) query.list();
            transaction.commit();
            return relations;
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
    public PersistentRelationship read(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            PersistentRelationship persistentRelationship = (PersistentRelationship) session.get(PersistentRelationship.class, id);
            transaction.commit();
            return persistentRelationship;
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
            PersistentRelationship persistentRelationship = (PersistentRelationship) session.load(PersistentRelationship.class, id);
            session.delete(persistentRelationship);
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
    public boolean update(int id, int firstPerson, int secondPerson, String type) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            PersistentRelationship persistentRelationship = (PersistentRelationship) session.load(PersistentRelationship.class, id);
            persistentRelationship.setFirstPerson(firstPerson);
            persistentRelationship.setSecondPerson(secondPerson);
            persistentRelationship.setType(type);
            session.update(persistentRelationship);
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
