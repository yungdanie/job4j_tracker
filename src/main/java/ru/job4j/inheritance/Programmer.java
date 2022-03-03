package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String lang;

    public Programmer(String name, String surname, String education, String birthday, String spec, String lang) {
        super(name, surname, education, birthday, spec);
        this.lang = lang;
    }

    public void createProg() {
    }
}
