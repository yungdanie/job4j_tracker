package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ItemDescByNameTest {

    @Test
    public void sortDescByName() {
        List<Item> list = new ArrayList<>();
        list.add(new Item("A"));
        list.add(new Item("B"));
        list.add(new Item("C"));
        Collections.sort(list, new ItemDescByName());
        List<Item> expected = new ArrayList<>();
        expected.add(new Item("C"));
        expected.add(new Item("B"));
        expected.add(new Item("A"));
        assertTrue(list.equals(expected));
    }
}