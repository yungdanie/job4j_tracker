package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных - счёт пользователя.
 */

public class Account {

    /**
     * Поле реквизит описывает номер, по которому счёт можно найти.
     */

    private String requisite;

    /**
     * Поле баланс, описывает количество денег на счете.
     */

    private double balance;

    /**
     * Конструктор позволяющий инициализировать два поля переменной типа Account.
     * @param requisite - поле реквизит для инициализации.
     * @param balance - поле баланс для инициализации.
     */

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттер поля реквизит.
     * @return поле @see #requisite.
     */

    public String getRequisite() {
        return requisite;
    }

    /**
     * Сеттер поля реквизит.
     * @param requisite - реквизиты, которые назначаются для поля.
     */

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Геттер поля баланс.
     * @return поле @see #balance.
     */

    public double getBalance() {
        return balance;
    }

    /**
     * Сеттер поля баланс.
     * @param balance - баланс, которые назначаются для поля.
     */

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределенный метод Equals. Позволяет сравнивать переменные типа Account.
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределенный метод hashCode.
     * @return Возвращает уникальное число.
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}