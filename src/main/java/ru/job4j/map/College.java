package ru.job4j.map;

import java.util.*;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> rsl = Optional.empty();
        for (Student s : students.keySet()) {
            if (s.getAccount().equals(account)) {
                return Optional.of(s);
            }
        }
        return rsl;
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Subject> rsl = Optional.empty();
        Optional<Student> a = findByAccount(account);
        if (a.isPresent()) {
            Set<Subject> subjects = students.get(a.get());
            for (Subject s : subjects) {
                if (s.getName().equals(name)) {
                    return Optional.of(s);
                }
            }
        }
        return rsl;
    }

    public static String collect(String s) {
        String[] array = s.split(" ");
        for (var i = 0; i < array.length; i++) {
            array[i] = String.valueOf(array[i].charAt(0));
        }
        String res = "";
        for (var a : array) {
            res = res + a;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "North Atlantic Treaty Organization";
        String rsl = collect(s);
    }
}