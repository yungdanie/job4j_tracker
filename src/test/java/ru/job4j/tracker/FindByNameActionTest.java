package ru.job4j.tracker;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByNameActionTest {

    @Test
    public void findByNameTest() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = new Item("New item", 1);
        memTracker.add(item);
        FindByNameAction findByNameAction = new FindByNameAction(output);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("New item");
        findByNameAction.execute(input, memTracker);
        assertThat(output.toString()).isEqualTo("=== Find items by name ==="
                .concat(System.lineSeparator())
                .concat(item.toString())
                .concat(System.lineSeparator()));
    }
}