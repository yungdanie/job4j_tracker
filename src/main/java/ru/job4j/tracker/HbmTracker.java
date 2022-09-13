package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        try (Session session = sf.openSession()) {
            try {
                session.beginTransaction();
                session.save(item);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
            }
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        int res = 0;
        try (Session session = sf.openSession()) {
            try {
                session.beginTransaction();
                res = session.createQuery("update Item set name = :fName, created = :fCreated")
                        .setParameter("fName", item.getName())
                        .setParameter("fCreated", item.getCreated())
                        .executeUpdate();
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
            }
        }
        return res > 0;
    }

    @Override
    public boolean delete(int id) {
        int res = 0;
        try (Session session = sf.openSession()) {
            try {
                session.beginTransaction();
                res = session.createQuery("delete Item where id = :fId")
                        .setParameter("fId", id)
                        .executeUpdate();
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
            }
        }
        return res > 0;
    }

    @Override
    public List<Item> findAll() {
        List<Item> list = new ArrayList<>();
        try (Session session = sf.openSession()) {
            try {
                session.beginTransaction();
                list = session.createQuery("from Item", Item.class).list();
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
            }
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        try (Session session = sf.openSession()) {
            try {
                session.beginTransaction();
                list = session.createQuery("from Item where name = :fName", Item.class)
                        .setParameter("fName", key).list();
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
            }
        }
        return list;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (Session session = sf.openSession()) {
            try {
                session.beginTransaction();
                item = session.createQuery("from Item where id = :fId", Item.class)
                        .setParameter("fId", id).getSingleResult();
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
            }
        }
        return item;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
