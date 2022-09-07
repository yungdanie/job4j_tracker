package ru.job4j.tracker;


import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item {
    @EqualsAndHashCode.Include
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private LocalDateTime created = LocalDateTime.now();
    @Getter
    @Setter
    private String dataTime = created.format(FORMATTER);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Item(@NonNull String name) {
        this.name = name;
    }

    public Item(@NonNull int id) {
        this.id = id;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }
}