package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                return i;
            }
        }
        throw new ElementNotFoundException();
    }

    public static void main(String[] args) {
        String[] array = new String[4];
        try {
            indexOf(array, "key");
        } catch (ElementNotFoundException a) {
            a.printStackTrace();
        }
    }
}
