package org.project.service.bus.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

    private static SessionFactory sessionFactory;

    @BeforeAll
    static void setup() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }

    @Test
    void addedDriverIntoDatabaseShouldSaveAfterTransaction() {

        //given

        Driver driver = new Driver("Maciej", "Kowalski", 50230L);
        Driver driver1 = new Driver("Michał", "Wąs", 50235L);
        //when
        try {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.persist(driver);
            session.persist(driver1);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Error during adding Driver to Database!");
            e.printStackTrace();
        }
        //then
        System.out.println("Success ! Added new Driver to Database");

    }

    @Test
    void addedDriverToDatabaseShouldBeReadable() {
        //given
        Driver driver = new Driver("Maciej", "Kowalski", 50230L);
        Driver driver1 = new Driver("Michał", "Wąs", 50235L);
        try {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.persist(driver);
            session.persist(driver1);
            tx.commit();
        } catch (HibernateException e) {
            System.out.println("Error during adding Driver to Database!");
            e.printStackTrace();
        }

        //when
        try {
            Session session = sessionFactory.openSession();
            List<Driver> list = session.createQuery("from Driver",Driver.class).list();

            //then
            assertThat(list.size(),notNullValue());

            System.out.println("List of Drivers:\n");

            for (Driver el :
                    list) {
                System.out.println(el);
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }


}