package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private int salary;

    public Dentist(String name, String surname, String education, String birthday, int exp, int salary) {
        super(name, surname, education, birthday, exp);
        this.salary = salary;
    }

    public void cureTeeth() {
    }
}
