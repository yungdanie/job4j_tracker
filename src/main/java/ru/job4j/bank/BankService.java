package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<>());
        } else {
            System.out.println("Пользователь уже существует в системе");
        }
    }

    public void addAccount(String passport, Account account) {
        List<Account> accounts = users.get(findByPassport(passport));
        for (Account acc : accounts) {
            if (acc.equals(account)) {
                System.out.println("Такой счёт уже существует у пользователя");
            }
        }
        accounts.add(account);
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        if (findByPassport(passport) != null) {
            List<Account> accounts = users.get(findByPassport(passport));
            for (Account acc : accounts) {
                if (acc.getRequisite().equals(requisite)) {
                    return acc;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        if (findByRequisite(srcPassport, srcRequisite) != null
                && findByRequisite(destPassport, destRequisite) != null) {
            Account srcAcc = findByRequisite(srcPassport, srcRequisite);
            Account destAcc = findByRequisite(destPassport, destRequisite);
            if (srcAcc.getBalance() >= amount) {
                srcAcc.setBalance(srcAcc.getBalance() - amount);
                destAcc.setBalance(destAcc.getBalance() + amount);
                return true;
            } else {
                System.out.println("Недосаточно средств на счете!");
            }
        } else {
            System.out.println("Пользователи/Пользователь с указаннным пасспортом/ами не найдены");
        }
        return false;
    }
}