package ru.job4j.tracker;

import java.util.List;

public class SingleTracker {
    private static Tracker instance = null;

    private SingleTracker() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return instance.add(item);
    }

    public Item findById(int id) {
        return instance.findById(id);
    }

    public List<Item> findAll() {
        return instance.findAll();
    }

    public List<Item> findByName(String name) {
        return instance.findByName(name);
    }

    public boolean replace(int id, Item item) {
        return instance.replace(id, item);
    }

    public boolean delete(int id) {
        return instance.delete(id);
    }
}

