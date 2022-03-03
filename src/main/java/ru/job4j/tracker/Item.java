package ru.job4j.tracker;

public class Item {
    private int id;
    private String name;

    Item() {
    }

    Item(String name) {
        this.name = name;
    }

    Item(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}