package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int res = 0;
        int i = 0;
        int leftLength = left.length();
        int rightLength = right.length();
        boolean cond = leftLength > rightLength;
        int b = cond ? rightLength : leftLength;
        for (; i < b; i++) {
            res += Character.compare(left.charAt(i),
                    right.charAt(i));
        }
        if (leftLength == rightLength) {
            return res;
        }
        b = cond ? leftLength : rightLength;
        for (; i < b; i++) {
            res += cond ? 1 : -1;
        }
        return res;
    }
}
