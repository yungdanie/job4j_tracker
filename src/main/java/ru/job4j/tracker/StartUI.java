package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    private Item time = new Item();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    private String formatted = time.getDataTime().format(formatter);

    public void getFormat() {
        System.out.println(formatted);
    }

    public static void main(String[] args) {
        StartUI time = new StartUI();
        time.getFormat();
    }
}
