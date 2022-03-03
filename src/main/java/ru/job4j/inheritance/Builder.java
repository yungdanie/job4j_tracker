package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String type;

    public Builder(String name, String surname, String education, String birthday, String spec, String type) {
        super(name, surname, education, birthday, spec);
        this.type = type;
    }

    public void createObj() {
    }
}
