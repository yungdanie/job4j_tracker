package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class Comparator {
    public static void main(String[] args) {
        List<Integer> abc = new ArrayList<>();
        abc.add(1);
        abc.add(2);
        abc.add(3);
        abc.sort(java.util.Comparator.naturalOrder());
        for (Integer b : abc) {
            System.out.println(b);
        }
        abc.sort(java.util.Comparator.reverseOrder());
        for (Integer b : abc) {
            System.out.println(b);
        }
    }
}
