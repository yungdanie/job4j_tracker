package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void jobAscByName() {
        Comparator<Job> comp = new JobAscByName();
        int res = comp.compare(new Job("A", 2),
                new Job("B", 1));
        assertThat(res, lessThan(0));
    }

    @Test
    public void jobDescByName() {
        Comparator<Job> comp = new JobDescByName();
        int res = comp.compare(new Job("A", 2),
                new Job("B", 1));
        assertThat(res, greaterThan(0));
    }

    @Test
    public void jobAscByPriority() {
        Comparator<Job> comp = new JobAscByPriority();
        int res = comp.compare(new Job("A", 2),
                new Job("B", 1));
        assertThat(res, greaterThan(0));
    }

    @Test
    public void jobDescByPriority() {
        Comparator<Job> comp = new JobDescByPriority();
        int res = comp.compare(new Job("A", 2),
                new Job("B", 1));
        assertThat(res, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("1", 1),
                new Job("1", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByPriorityAndName() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = cmpNamePriority.compare(
                new Job("A", 0),
                new Job("B", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByEqualsPriorityAndName() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority().thenComparing(new JobAscByName());
        int rsl = cmpNamePriority.compare(
                new Job("A", 1),
                new Job("B", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}