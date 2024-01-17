package pl.edu.wat.mspw_backend.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainDao {

    private SessionFactory sessionFactory;

    private static MainDao instance;
    public static MainDao getInstance() {
        if ( instance == null ) {
            instance = new MainDao();
            instance.configureFactory();
        }
        return instance;
    }
    private void configureFactory()
    {
        try {
            sessionFactory = new WildCardConfiguration()
                    .addPackage("pl.edu.wat.mspw_backend.model")
                    .configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public <T> void createRecord(T obj) {
        try (Session session = sessionFactory.openSession()) {
            // Rozpoczęcie transakcji
            Transaction transaction = session.beginTransaction();
            session.persist(obj);
//            session.save(obj);
            transaction.commit();

        }
    }

    public <T> T readRecordByID(Class<T> entityClass, int id) {

        try (Session session = sessionFactory.openSession()) {
            // Pobieranie obiektu z bazy danych
            T entity = session.get(entityClass, id);

            if (entity == null)  {
                System.out.println("Obiekt o danym identyfikatorze nie istnieje.");
            }

            return entity;

        }

    }

    public <T> List<T> readAllRecords(Class<T> entityClass) {
        try (Session session = sessionFactory.openSession()) {

            String queryString = "FROM " + entityClass.getSimpleName();
            List<T> records = session.createQuery(queryString, entityClass).list();

            return records;
        }
    }

    public <T> void updateRecord(T updatedEntity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(updatedEntity);
            transaction.commit();
        }
        closeSessionFactory();// do wyjebania
    }

    public <T> void deleteByID(Class<T> entityClass, int entityIdToDelete) {
        // nie usunie jeśli będą blokować go constrainty w postaci implementowania obiektu w innych rekordach
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            T entityToDelete = session.load(entityClass, entityIdToDelete);

            if (entityToDelete != null) {
                session.delete(entityToDelete);
            }
            transaction.commit();
        }
        closeSessionFactory();// do wyjebania
    }


    private void initializeSessionFactory() {
        if(sessionFactory == null)
        {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }
    }

    private void closeSessionFactory() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }


}