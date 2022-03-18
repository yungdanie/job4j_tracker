package ru.job4j.collection;

import java.util.Comparator;

public class JobDescByName implements Comparator<Job> {
    @Override
    public int compare(Job j1, Job j2) {
        return -j1.getName().compareTo(j2.getName());
    }
}
