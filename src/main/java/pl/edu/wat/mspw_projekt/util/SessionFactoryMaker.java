package pl.edu.wat.mspw_projekt.util;

import org.hibernate.MappingException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.edu.wat.mspw_projekt.model.*;


import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SessionFactoryMaker {
    private static SessionFactory factory;

    private static void configureFactory()
    {
        try {
            factory = new WildCardConfiguration()
                    .addPackage("pl.edu.wat.mspw_projekt.model")
                    .addAnnotatedClass(PropellantAndLubricant.class)
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
                    .addAnnotatedClass(Ammo.class)
                    .addAnnotatedClass(AmmoCategory.class)
                    .addAnnotatedClass(GuidanceType.class)
                    .addAnnotatedClass(WarheadType.class)
                    .addAnnotatedClass(WarheadGuidedType.class)
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

