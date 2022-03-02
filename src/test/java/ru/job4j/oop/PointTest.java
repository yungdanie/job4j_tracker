package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
    @Test
    public void when00to20then2() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double expected = 2;
        double out = a.distance(b);
        assertEquals(expected, out, 0.01);
    }

    @Test
    public void when11to22then1dot4142() {
        Point a = new Point(1, 1);
        Point b = new Point(2, 2);
        double expected = 1.4142;
        double out = a.distance(b);
        assertEquals(expected, out, 0.01);
    }

    @Test
    public void when17to55then4dot4721() {
        Point a = new Point(1, 7);
        Point b = new Point(5, 5);
        double expected = 4.4721;
        double out = a.distance(b);
        assertEquals(expected, out, 0.01);
    }

    @Test
    public void when25to37then2dot236() {
        Point a = new Point(2, 5);
        Point b = new Point(3, 7);
        double expected = 2.236;
        double out = a.distance(b);
        assertEquals(expected, out, 0.01);
    }

    @Test
    public void when000to105then5dot099() {
        Point a = new Point(0, 0,  0);
        Point b = new Point(1, 0, 5);
        double expected = 5.099;
        double out = a.distance3d(b);
        assertEquals(expected, out, 0.01);
    }

    @Test
    public void when111to666then8dot66() {
        Point a = new Point(1, 1,  1);
        Point b = new Point(6, 6, 6);
        double expected = 8.66;
        double out = a.distance3d(b);
        assertEquals(expected, out, 0.01);
    }
}