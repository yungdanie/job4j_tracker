package ru.job4j.collection;

import java.util.Comparator;

public class JobDescByPriority implements Comparator<Job> {
    @Override
    public int compare(Job j1, Job j2) {
        return -Integer.compare(j1.getPriority(), j2.getPriority());
    }
}
