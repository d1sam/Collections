package ua.od.atomspace;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Map<Car, String> hashMapCar = new HashMap<>();
        Set<Car> hashSetCar = new HashSet<>();
        Car car1 = new Car("Green", "BMW");
        Car car2 = new Car("Green", "BMW");

        hashMapCar.put(car1, "Odesa");//добавляем объект класса Car в качестве ключа
        hashMapCar.put(car2, "Kyiv");//добавляем другой объект класса Car в качестве ключа, который по полям идентичен первому car1

        hashSetCar.add(car1);//добавляем в множество первый объект класса Car
        hashSetCar.add(car2);//добавляем в множество второй объект класса Car, который по поля идентичен первому car1

        System.out.println("hashMap with cars = " + hashMapCar);
        System.out.println("hashSet with cars = " + hashSetCar);

        // из-за того, что методы hashCode() и equals(..) не переопределены в ключи мапы и в сет попадают объекты идентичные по полям
        // мапа или сет не может сравнить объекты по внутенним полям поэтому она и думает, что это разные объекты
        // нужно переопределить методы hashCode() и equals(..), чтобы было корректное сравнение добавляемого элемента с уже добавленными элементами

        Map<Person, String> hashMapPerson = new HashMap<>();
        Set<Person> hashSetPerson = new HashSet<>();
        Person person1 = new Person(0, "Bob");
        Person person2 = new Person(0, "Bob");

        hashMapPerson.put(person1, "Odesa");//добавляем объект класса Person в качестве ключа
        hashMapPerson.put(person2, "Kyiv");//добавляем другой объект класса Person в качестве ключа, который по полям идентичен первому person1

        hashSetPerson.add(person1);//добавляем в множество первый объект класса Person
        hashSetPerson.add(person2);//добавляем в множество второй объект класса Car, который по поля идентичен первому person1

        System.out.println("hashMap with people = " + hashMapPerson);
        System.out.println("hashSet with people = " + hashSetPerson);

    }
}

class Car {
    private String colour;
    private String brand;

    public Car(String colour, String brand) {
        this.colour = colour;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "colour='" + colour + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}

class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
