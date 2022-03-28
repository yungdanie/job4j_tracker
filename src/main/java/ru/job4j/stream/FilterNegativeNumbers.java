package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, -1, -2, 3, -4, 5, -6);
        List<Integer> positive = numbers.stream().filter(x -> x > 0).toList();
        positive.forEach(System.out::println);
    }
}