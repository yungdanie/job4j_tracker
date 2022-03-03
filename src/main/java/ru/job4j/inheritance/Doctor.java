package ru.job4j.inheritance;

public class Doctor extends Profession {
    private int exp;

    public Doctor(String name, String surname, String education, String birthday, int exp) {
        super(name, surname, education, birthday);
        this.exp = exp;
    }

    public void solveDocProblem() {
    }
}
