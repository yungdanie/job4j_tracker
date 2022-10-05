package ru.job4j.tracker;

import org.assertj.core.api.Assertions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TrackerHbmTest {

    private static HbmTracker tracker;

    private static SessionFactory sessionFactory;

    @BeforeAll
    public static void connectDB() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        sessionFactory = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory();
        tracker = new HbmTracker(sessionFactory, registry);
    }

    @AfterEach
    public void cleanDB() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.createQuery("delete from Item").executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Test
    public void whenAddNewItemAndGetSameName() {
        Item item = new Item();
        item.setName("testing_get_name");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        Assertions.assertThat(result.getName()).isEqualTo(item.getName());
    }

    @Test
    public void whenUpdateItemAndGetName() {
        Item item = new Item();
        item.setName("testing_update");
        tracker.add(item);
        String newName = "testing_update";
        item.setName("testing_update");
        tracker.replace(item.getId(), item);
        Item result = tracker.findById(item.getId());
        Assertions.assertThat(result.getName()).isEqualTo(newName);
    }

    @Test
    public void whenDeleteItem() {
        Item item = new Item();
        item.setName("deleted item");
        tracker.add(item);
        boolean result = tracker.delete(item.getId());
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void whenGetAllTask() {
        Item firstItem = new Item();
        Item secondItem = new Item();
        Item thirdItem = new Item();
        firstItem.setName("first_item");
        secondItem.setName("second_item");
        thirdItem.setName("third_item");
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        Assertions.assertThat(tracker.findAll()).isEqualTo(List.of(firstItem, secondItem, thirdItem));
    }

    @Test
    public void whenFindByName() {
        Item firstItem = new Item();
        Item secondItem = new Item();
        String name = "item";
        firstItem.setName(name);
        secondItem.setName(name);
        tracker.add(firstItem);
        tracker.add(secondItem);
        Assertions.assertThat(tracker.findByName(name)).isEqualTo(List.of(firstItem, secondItem));
    }
}
