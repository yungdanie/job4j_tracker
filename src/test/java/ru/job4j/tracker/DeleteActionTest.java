package ru.job4j.tracker;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteActionTest {

    @Test
    public void whenDeleteAction() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        memTracker.add(new Item(1, "New item"));
        DeleteAction deleteAction = new DeleteAction(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        deleteAction.execute(input, memTracker);
        assertThat(output.toString()).isEqualTo("=== Delete item ==="
                        .concat(System.lineSeparator())
                        .concat("Заявка удалена успешно.")
                        .concat(System.lineSeparator()));
    }
}