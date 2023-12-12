package pl.edu.wat.mspw_projekt.service;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

class MainDao {

    private SessionFactory sessionFactory;
    private static MainDao instance;
    private MainDao() {
        initializeSessionFactory();
    };
    public static MainDao getInstance() {
        if ( instance == null ) {
            instance = new MainDao();
        }
        return instance;
    }


    public <T> void createRecord(T obj) {
        try (Session session = sessionFactory.openSession()) {
            // Rozpoczęcie transakcji
            Transaction transaction = session.beginTransaction();

            session.save(obj);

            // Commit transakcji
            transaction.commit();

        }
        closeSessionFactory();// do wyjebania
    }

    public <T> T readRecordByID(Class<T> entityClass, int id) {

        try (Session session = sessionFactory.openSession()) {
            // Pobieranie obiektu z bazy danych
            T entity = session.get(entityClass, id);

            if (entity == null)  {
                System.out.println("Obiekt o danym identyfikatorze nie istnieje.");
            }

            closeSessionFactory();// do wyjebania

            return entity;

        }

    }

    public <T> List<T> readAllRecords(Class<T> entityClass) {
        try (Session session = sessionFactory.openSession()) {

            String queryString = "FROM " + entityClass.getSimpleName();
            List<T> records = session.createQuery(queryString, entityClass).list();

            closeSessionFactory();// do wyjebania

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