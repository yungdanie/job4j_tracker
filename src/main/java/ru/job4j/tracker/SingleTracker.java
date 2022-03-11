package ru.job4j.tracker;

public class SingleTracker {
    private static Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    public static Tracker getInstance() {
        return tracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String name) {
        return tracker.findByName(name);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}

