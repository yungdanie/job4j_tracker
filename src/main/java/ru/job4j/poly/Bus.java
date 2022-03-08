package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Транспорт начал движение");
    }

    @Override
    public void passengers(int num) {
        System.out.println("Количество пассажиров: " + num);
    }

    @Override
    public double refuel(int liters) {
        System.out.println("Машина будет заправлена на "
                + liters + " литров");
        return 0;
    }
}
