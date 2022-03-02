package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void when24then4() {
        Max num = new Max();
        int in = num.max(2, 4);
        int expected = 4;
        assertEquals(expected, in);
    }

    @Test
    public void when2810then10() {
        Max num = new Max();
        int in = num.max(2, 8, 10);
        int expected = 10;
        assertEquals(expected, in);
    }

    @Test
    public void when1012913then13() {
        Max num = new Max();
        int in = num.max(10, 12, 9, 13);
        int expected = 13;
        assertEquals(expected, in);
    }
}