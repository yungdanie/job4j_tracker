package ru.job4j.tracker;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@Table(name = "items")
@ToString
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "create_time")
    private LocalDateTime created = LocalDateTime.now();

    @Transient
    private String dataTime = created.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    public Item(@NonNull String name) {
        this.name = name;
    }

    public Item(@NonNull int id) {
        this.id = id;
    }

    public Item() {
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}