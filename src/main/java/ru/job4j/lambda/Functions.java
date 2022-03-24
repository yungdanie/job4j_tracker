package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Functions {

    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        Supplier<List<Double>> suppList = ArrayList::new;
        List<Double> list = suppList.get();
        Consumer<Double> addList = list::add;
        for (double i = start; i < end; i++) {
            addList.accept(func.apply(i));
        }
        return list;
    }
}
