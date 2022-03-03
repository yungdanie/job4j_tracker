package ru.job4j.inheritance;

public class Engineer extends Profession {
    private String spec;

    public Engineer(String name, String surname, String education, String birthday, String spec) {
        super(name, surname, education, birthday);
        this.spec = spec;
    }

    public void solveEngProblem() {
    }
}
