package ru.job4j.poly;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass() + " едет по рельсам");
    }

    @Override
    public void arrival() {
        System.out.println(getClass() + " прибыл в аэропорт");
    }
}
