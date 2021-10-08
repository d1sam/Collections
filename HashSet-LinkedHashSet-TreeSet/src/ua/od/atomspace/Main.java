package ua.od.atomspace;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();// порядок элементов после добавления случайный
        Set<String> linkedHashSet = new LinkedHashSet<>();// элементы хранятся в порядке добавления
        Set<String> treeSet = new TreeSet<>();// элементы хранятся отсортированными по ключу
        //поиск по множеству обрабатывается очень быстро из-за хэширования элементов
        hashSet.add("Bob");
        System.out.println(hashSet.contains("Bob"));

        Set<Integer> set1 = new HashSet<>();
        set1.add(0);
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);
        set2.add(7);// в сете только уникальные элементы

        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println(union);// [0, 1, 2, 3, 4, 5, 6, 7]

        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println(intersection);// [2, 3, 4, 5]

        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println(difference);// [0, 1]

        Set<Integer> symmetricDifference = new HashSet<>(set1);
        symmetricDifference.addAll(set2);
        symmetricDifference.removeAll(intersection);
        System.out.println(symmetricDifference);// [0, 1, 6, 7]

    }
}
