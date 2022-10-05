package ru.job4j.tracker;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class TrackerHbmTest {

    private final HbmTracker tracker = new HbmTracker();


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
        String oldName = "testing_update";
        item.setName(oldName);
        tracker.add(item);
        item.setName("new_name");
        tracker.replace(item.getId(), item);
        Item result = tracker.findById(item.getId());
        Assertions.assertThat(result.getName()).isEqualTo(oldName);
    }

    @Test
    public void whenDeleteItem() {
        Item item = new Item();
        item.setName("deleted item");
        tracker.add(item);
        boolean result = tracker.delete(item.getId());
        Assertions.assertThat(result).isTrue();
    }

}
