package ru.job4j.tracker;

public class DeleteAll implements UserAction {
    @Override
    public String name() {
        return "Delete All.... ";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        tracker.findAll().forEach(item -> tracker.delete(item.getId()));
        return true;
    }
}
