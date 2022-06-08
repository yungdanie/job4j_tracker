package ru.job4j.tracker;

public class AddALotOfItems implements UserAction {

    private final Output out;

    public AddALotOfItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add a lot of Items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int i = input.askInt("Enter num of new items");
        for (int b = 0; b < i; b++) {
            tracker.add(new Item(i));
        }
        return true;
    }
}
