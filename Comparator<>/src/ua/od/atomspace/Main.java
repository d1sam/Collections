package ua.od.atomspace;

import java.text.CollationElementIterator;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();// создаем эррейлист из строк
        strList.add("Dima");
        strList.add("Anton");
        strList.add("Viktoriya");
        strList.add("Max");
        strList.add("Alina");

        Collections.sort(strList);// вызываем статический метод сортировки и сортируем по алфавиту (эта сортировка дэфолтная для строк)
        System.out.println(strList);

        strList.sort(new StringLengthComparator());// вызываем метод класса List и передаем объект класса, что имплементит интерфейс Comparator
        System.out.println(strList);

        List<Integer> intList = new ArrayList<>();// создаем эррейлист из целых чисел
        intList.add(500);
        intList.add(200);
        intList.add(400);
        intList.add(300);
        intList.add(100);
        intList.add(600);

        Collections.sort(intList);// сортируем дєфолтной реализацией сортировки инта (по возрастанию)
        System.out.println(intList);

        Collections.sort(intList, new Comparator<Integer>() {// сортируем по убыванию с помощью передачи Анонимного класса в метод  sort(), реализующего Comparator<>
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 < o2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(intList);

        List<Person> personList = new ArrayList<>();// создаем эррейлист из людей (пользовательский класс)
        personList.add(new Person(10, "Bob"));
        personList.add(new Person(90, "Max"));
        personList.add(new Person(8, "Bill"));
        personList.add(new Person(15, "Henry"));
        personList.add(new Person(35, "Mick"));

        System.out.println(personList);

        Collections.sort(personList, (o1, o2) -> {// сортируем по возрастанию id с помощью передачи в метод лямбды реализующей интерфейс Comparator<>
            if (o1.getId() > o2.getId()) {
                return 1;
            } else if (o1.getId() < o2.getId()) {
                return -1;
            } else {
                return 0;
            }
        });

        System.out.println(personList);
    }
}

class StringLengthComparator implements Comparator<String> {

    /*
     * o1 > o2 => 1;
     * o1 < o2 => -1;
     * o1 == o2 => 0;
     *
     * compare(2,1) => 1;
     * compare(1,2) => -1;
     * compare(1,1) => 0;
     * */

    @Override
    public int compare(String o1, String o2) {//сравниваем 2 объекта класса String
        if (o1.length() > o2.length()) {
            return 1;
        } else if (o1.length() < o2.length()) {
            return -1;
        } else {
            return 0;
        }
    }
}

class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}