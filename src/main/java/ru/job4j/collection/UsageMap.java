package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("abdula@gmail.com", "Abdula Abdul Abdulov");
        map.put("ivanov@gmail.com", "Ivan Ivanov Ivanovich");
        for (String key : map.keySet()) {
            System.out.println("value = " + map.get(key));
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("value = " + entry.getValue());
        }
    }
}
