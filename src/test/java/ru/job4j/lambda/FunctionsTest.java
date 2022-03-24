package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class FunctionsTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = Functions.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenLinearResults() {
        List<Double> result = Functions.diapason(0, 4, x -> x*x);
        List<Double> expected = Arrays.asList(0D, 1D, 4D, 9D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExpFunctionThenLinearResults() {
        List<Double> result = Functions.diapason(2, 3, x -> Math.exp(1) * Math.exp(1) + x);
        List<Double> expected = List.of(9.38D);
        double delta = 0.01;
        assertEquals(result.get(0), expected.get(0), delta);
    }
}