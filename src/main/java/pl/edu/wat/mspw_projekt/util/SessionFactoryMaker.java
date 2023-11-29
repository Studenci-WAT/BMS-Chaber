package pl.edu.wat.mspw_projekt.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.edu.wat.mspw_projekt.model.*;

public class SessionFactoryMaker {
    private static SessionFactory factory;

    private static void configureFactory()
    {
        try {
            factory = new Configuration()
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

    public static org.hibernate.SessionFactory getFactory() {
        if (factory == null) {
            configureFactory();
        }

        return factory;
    }

}
