package ru.job4j.stream;

import java.util.List;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{"
                + "suit=" + suit
                + ", value=" + value
                + '}';
    }

    enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    enum Value {
        V_6, V_7, V_8
    }

    public static void main(String[] args) {
        List<Card> deck = Stream.of(Suit.values())
                .flatMap(x ->
                        Stream.of(Value.values())
                        .map(y -> new Card(x, y)))
                .toList();
        System.out.println(deck);
    }
}