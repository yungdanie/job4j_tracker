package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ItemAscByNameTest {

    @Test
    public void sortAscByName() {
        List<Item> list = new ArrayList<>();
        list.add(new Item("B"));
        list.add(new Item("C"));
        list.add(new Item("A"));
        Collections.sort(list, new ItemAscByName());
        List<Item> expected = new ArrayList<>();
        expected.add(new Item("A"));
        expected.add(new Item("B"));
        expected.add(new Item("C"));
        assertTrue(list.equals(expected));
    }
}