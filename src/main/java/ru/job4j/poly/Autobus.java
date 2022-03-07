package ru.job4j.poly;

public class Autobus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass() + " едет по дороге");
    }

    @Override
    public void arrival() {
        System.out.println(getClass() + " прибыл на остановку");
    }
}
