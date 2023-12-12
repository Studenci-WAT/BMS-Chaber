package pl.edu.wat.mspw_projekt.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jboss.jandex.Main;
import org.junit.jupiter.api.Test;
import pl.edu.wat.mspw_projekt.service.MainDao;
import pl.edu.wat.mspw_projekt.util.SessionFactoryMaker;

class AmmoTest {
    @Test
    public void test1() {
        AmmoCategory ammoCategory = AmmoCategory.builder()
                        .name("Test ammo category")
                        .shortcut("TMC")
                        .build();

//        Ammo ammo = Ammo.builder()
//                .name("Test2")
//                .category(ammoCategory)
//                .code("T")
//                .build();

        MainDao.getInstance().createRecord(ammoCategory);

//        SessionFactory factory = SessionFactoryMaker.getFactoryTest();
//
//        try (Session session = factory.openSession()) {
//            Transaction tx = session.beginTransaction();
//            session.save(ammoCategory);
//            session.save(ammo);
//            tx.commit();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
    }
}