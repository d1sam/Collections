package ua.od.atomspace;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {

    public static void main(String[] args) {
        Queue<Person> personQueue = new LinkedList<>();
        personQueue.add(new Person(1));
        personQueue.add(new Person(4));
        personQueue.add(new Person(2));
        personQueue.add(new Person(3));

        for (Person person : personQueue) {
            System.out.println(person);
        }

        Queue<Person> blockingQueuePerson = new ArrayBlockingQueue<>(4);

        // .remove() удаляет, в случае успеха возвращает head очереди, а иначе выбрасывает Exception
        // .poll() удаляет, в случае успеха возвращает head очереди, а иначе null
        try {
            blockingQueuePerson.remove();
        } catch (Exception e) {
            System.out.println("Не удалось удалить, ибо очередь пуста!");
        }
        System.out.println(blockingQueuePerson.poll());

        // .element() выдает без удаления, в случае успеха возвращает head очереди, а иначе выбрасывает Exception
        // .peek() выдает без удаления, в случае успеха возвращает head очереди, а иначе null
        try {
            blockingQueuePerson.element();
        } catch (Exception e) {
            System.out.println("Не удалось вернуть, ибо очередь пуста!");
        }
        System.out.println(blockingQueuePerson.peek());

        blockingQueuePerson.addAll(personQueue); // передали в очередь с ограниченной пропускной способностью старую очередь
        System.out.println(blockingQueuePerson);

        // .add() добавляет, в случае успеха возвращает true, а иначе выбрасывает Exception
        // .offer() добавляет, в случае успеха возвращает true, а иначе false
        try {
            blockingQueuePerson.add(new Person(5));
        } catch (Exception e) {
            System.out.println("Не удалось добавить, ибо очередь переполнена!");
        }
        System.out.println("Результат добавления нового элемента в переполненую очередь = " + blockingQueuePerson.offer(new Person(5)));
    }
}

class Person {
    private int id;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }

    public Person(int id) {
        this.id = id;
    }
}
