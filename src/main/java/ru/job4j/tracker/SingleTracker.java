package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.List;

public class SingleTracker {

    private static Store instance = null;

    private SingleTracker() {
    }

    public static Store getInstance() {
        if (instance == null) {
            instance = new MemTracker();
        }
        return instance;
    }

    public Item add(Item item) throws SQLException {
        return instance.add(item);
    }

    public Item findById(int id) throws SQLException {
        return instance.findById(id);
    }

    public List<Item> findAll() throws SQLException {
        return instance.findAll();
    }

    public List<Item> findByName(String name) throws SQLException {
        return instance.findByName(name);
    }

    public boolean replace(int id, Item item) throws SQLException {
        return instance.replace(id, item);
    }

    public boolean delete(int id) throws SQLException {
        return instance.delete(id);
    }
}

