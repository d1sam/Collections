package ua.od.atomspace;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Map<Integer,String> hashMap = new HashMap<>();// порядок элементов после добавления случайный
        Map<Integer,String> linkedHashMap = new LinkedHashMap<>();// элементы хранятся в порядке добавления
        Map<Integer,String> treeMap = new TreeMap<>();// элементы хранятся отсортированными по ключу

        testMap(hashMap);
        testMap(linkedHashMap);
        testMap(treeMap);
    }

    public static void testMap(Map<Integer, String> map) {
        map.put(21, "Bob");
        map.put(14, "Mike");
        map.put(44, "Fred");
        map.put(90, "Leo");
        map.put(0, "Christiano");
        map.put(823, "William");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

