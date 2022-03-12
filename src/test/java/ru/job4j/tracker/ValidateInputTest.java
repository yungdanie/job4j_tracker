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
        actual[0] = input.askInt("Enter menu:");
        actual[1] = input.askInt("Enter menu:");
        actual[2] = input.askInt("Enter menu:");
        actual[3] = input.askInt("Enter menu:");
        expected[0] = Integer.parseInt(array[0]);
        expected[1] = Integer.parseInt(array[1]);
        expected[2] = Integer.parseInt(array[2]);
        expected[3] = Integer.parseInt(array[3]);
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