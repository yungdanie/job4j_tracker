package ru.job4j.tracker;

import java.util.List;

public class ShowAllItemsAction implements UserAction {
    private final Output out;

    public ShowAllItemsAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all items ===");
        List<Item> items = tracker.findAll();
        if (!items.isEmpty()) {
            for (Item item : tracker.findAll()) {
                out.println(item);
            }
        } else {
            out.println("Хранилище еще не содержит заявок");
        }
        return true;
    }
}
