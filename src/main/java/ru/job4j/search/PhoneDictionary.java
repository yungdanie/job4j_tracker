package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> eqName = person -> person.getName().contains(key);
        Predicate<Person> eqSurName = person -> person.getSurname().contains(key);
        Predicate<Person> eqAdress = person -> person.getAddress().contains(key);
        Predicate<Person> eqPhone = person -> person.getPhone().contains(key);
        Predicate<Person> combine = eqName.or(eqSurName.or(eqAdress.or(eqPhone)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
