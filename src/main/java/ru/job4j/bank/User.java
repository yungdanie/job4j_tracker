package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных - пользователь.
 */

public class User {

    /**
     * Поле паспорт описывает уникальный номер пользователя.
     */

    private String passport;

    /**
     * Поле юзернейм описывает имя пользователя.
     */

    private String username;

    /**
     * Конструктор, позволяет инициализировать два поля переменной типа User.
     * @param passport - поле паспорт для инициализации.
     * @param username - поле юзернейм для инициализации.
     */

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Геттер поля паспорт.
     * @return Возвращает поле паспорт @see #passport.
     */

    public String getPassport() {
        return passport;
    }

    /**
     * Сеттер поля паспорт.
     * @param passport Передаваемое поле паспорт для назначения.
     */

    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Геттер поля юзернейм.
     * @return Возвращает поле юзернейм @see #username.
     */

    public String getUsername() {
        return username;
    }

    /**
     * Сеттер поля юзернейм.
     * @param username Передаваемое поле юзернейм для назначения @see #username.
     */

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределенный метод Equals. Позволяет сравнивать переменные типа User.
     * @param o - объект для сравнения.
     * @return возвращает true, если переменные равны, иначе false.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
