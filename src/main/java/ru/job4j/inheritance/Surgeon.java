package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private int numOper;

    public Surgeon(String name, String surname, String education, String birthday, int exp) {
        super(name, surname, education, birthday, exp);
        this.numOper = numOper;
    }

    public void cutStomach() {
    }
}
