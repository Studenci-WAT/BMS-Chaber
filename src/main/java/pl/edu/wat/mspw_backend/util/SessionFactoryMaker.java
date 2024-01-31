package pl.edu.wat.mspw_backend.util;

import org.hibernate.SessionFactory;
import pl.edu.wat.mspw_backend.model.*;

public class SessionFactoryMaker {
    private static SessionFactory factory;

    private static void configureFactory()
    {
        try {
            factory = new WildCardConfiguration()
                    .addPackage("pl.edu.wat.mspw_projekt.model")
                    .configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    private static void configureFactoryTest()
    {
        try {
            factory = new WildCardConfiguration()
                    .addAnnotatedClass(AmoEntity.class)
                    .addAnnotatedClass(KategoriaAmoEntity.class)
                    .addAnnotatedClass(RodzajNaprowEntity.class)
                    .addAnnotatedClass(RodzajGlowicyBojEntity.class)
                    .addAnnotatedClass(RodzajGlowicyNaprowEntity.class)
                    .configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getFactory() {
        if (factory == null) {
            configureFactory();
        }
        return factory;
    }
    public static SessionFactory getFactoryTest() {
        if (factory == null) {
            configureFactoryTest();
        }
        return factory;
    }
}

