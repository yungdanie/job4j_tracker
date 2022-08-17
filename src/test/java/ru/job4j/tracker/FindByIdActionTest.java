package ru.job4j.tracker;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByIdActionTest {

    @Test
    public void findByIdTest() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = new Item("New item", 1);
        memTracker.add(item);
        FindByIdAction findByIdAction = new FindByIdAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        findByIdAction.execute(input, memTracker);
        assertThat(output.toString()).isEqualTo("=== Find item by id ==="
                .concat(System.lineSeparator())
                .concat(item.toString())
                .concat(System.lineSeparator()));
    }
}