package ru.job4j.recursion;

public class PowANTimesRecursion {
    public static int calculate(int a, int n) {
        return n != 1 ? calculate(a, n - 1) * a : a;
    }

    public static void main(String[] args) {
        System.out.println(calculate(2, 5));
    }
}
