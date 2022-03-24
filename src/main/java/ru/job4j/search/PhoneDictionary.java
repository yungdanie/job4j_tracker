package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> eqName = person -> person.getName().equals(key);
        Predicate<Person> eqSurName = person -> person.getSurname().equals(key);
        Predicate<Person> eqAdress = person -> person.getAddress().equals(key);
        Predicate<Person> eqPhone = person -> person.getPhone().equals(key);
        Predicate<Person> combine = person -> eqName.or(eqSurName.or(eqAdress.or(eqPhone))).test(person);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
