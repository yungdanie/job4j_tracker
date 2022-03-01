package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Hare zayac = new Hare();
        Wolf volk = new Wolf();
        Fox lisa = new Fox();
        Ball kolobok = new Ball();
        zayac.tryEat(kolobok);
        volk.tryEat(kolobok);
        lisa.tryEat(kolobok);
    }
}
