package ru.job4j.poly;

public class Plane implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass() + " летит");
    }

    @Override
    public void arrival() {
        System.out.println(getClass() + " прибыл в аэропорт");
    }

    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle autobus = new Autobus();
        Vehicle[] array = {plane, train, autobus};
        for (Vehicle a: array) {
            a.move();
            a.arrival();
        }
    }
}
