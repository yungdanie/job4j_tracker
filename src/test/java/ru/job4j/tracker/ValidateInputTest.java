package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenMultiValidInput() {
        String[] array = {"1", "2", "51", "100"};
        Output out = new StubOutput();
        Input in = new StubInput(
                array
        );
        ValidateInput input = new ValidateInput(out, in);
        int[] actual = new int[array.length];
        int[] expected = new int[array.length];
        for (int i = 0; i < actual.length; i++) {
            actual[i] = input.askInt("Enter menu:");
            expected[i] = Integer.parseInt(array[i]);
        }
        assertThat(expected, is(actual));
    }

    @Test
    public void whenInputIsNegativeNum() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-10"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-10));
    }
}