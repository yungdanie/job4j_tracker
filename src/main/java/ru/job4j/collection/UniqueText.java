package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String original : origin) {
            check.add(original);
        }
        for (String dupl : text) {
            if (!check.contains(dupl)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
