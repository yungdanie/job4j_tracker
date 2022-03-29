package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает банковский сервсис используя классы модели данных
 * {@link User}, {@link Account}.
 * @version 1.0
 */

public class BankService {
    /**
     * Для хранения пользователей и их счётов используется коллекция типа HashMap.
     * Ключом является тип User {@link User}.
     * Значением является коллекция типа List, которая включает в себя счёты типа {@link Account}.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод позволяет добавить тип {@link User} в коллекцию
     * если такой пользователь не добавлен.
     * @param user пользователь, которого мы хотим добавить.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод позволяет добавить счёт пользователю.
     * @param passport паспорт пользователя, этому пользователю мы хотим добавить счёт.
     * @param account счёт, который мы передаём для добавления.
     */
    public void addAccount(String passport, Account account) {
        var user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }

    }

    /**
     * Метод позволяет найти пользователя по паспорту.
     * @param passport паспорт по которому будет проведён поиск в коллекции @see #users.
     * @return возвращает тип {@link User}, иначе null.
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(a -> a.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод позволяет найти счёт пользователя по данному реквизиту.
     * @param passport - паспорт пользователя, по которому будет проведён поиск в коллекции @see #users.
     * @param requisite - реквизиты пользователя, по которым будет найдет счёт @see #Account#requisite.
     * @return Возвращает счёт пользователя если он был найден, иначе null.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        var user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(a -> a.getRequisite()
                            .equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
    }

    /**
     * Метод позволяет отправить деньги пользователей с одного счёта на другой.
     * @param srcPassport - исходный паспорт, по нему будет найден пользователь, который отправляет деньги.
     * @param srcRequisite - исходный реквизит, по которому будет найден счёт у пользователя.
     *                     С этого счёта будут списаны деньги.
     * @param destPassport - паспорт назначения, по нему будет найден пользователь, который получает деньги.
     * @param destRequisite - реквизит назначения, по которому будет найден счёт у пользователя.
     *                      На этот счёт будут начислены деньги.
     * @param amount - сумма перевода.
     * @return Возвращает true, если перевод выполнен успешно, иначе false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        var srcAcc = findByRequisite(srcPassport, srcRequisite);
        var destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc.isPresent()
                && destAcc.isPresent()) {
            if (srcAcc.get().getBalance() >= amount) {
                srcAcc.get().setBalance(srcAcc.get().getBalance() - amount);
                destAcc.get().setBalance(destAcc.get().getBalance() + amount);
                return true;
            }
        }
        return false;
    }
}