package pl.edu.wat.mspw_projekt.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
import pl.edu.wat.mspw_projekt.util.SessionFactoryMaker;

class AmmoTest {
    @Test
    public void test1() {
        Ammo ammo = new Ammo();
        ammo.setName("Test1");
        SessionFactory factory = SessionFactoryMaker.getFactory();

        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(ammo);
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}