package ru.job4j.oop;

public class Max {
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    public int max(int first, int second, int third) {
        return max(first, second) == first && max(first, third) == first ? first : max(second, third);
    }

    public int max(int first, int second, int third, int fourth) {
        return max(max(first, second), max(third, fourth));
    }
}
