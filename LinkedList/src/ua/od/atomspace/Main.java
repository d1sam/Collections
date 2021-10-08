package ua.od.atomspace;

// РАЗНИЦА В ОПЕРАЦИЯХ МЕЖДУ ArrayList и LinkedList
//добавление в конец ArrayList'a производится в 2 раза быстрее, чем аналогичная операция в LinkedList'e,
//ибо в случае с ArrayList'oм в последнюю ячейку добавляется элемент, (при заполнении, идет расширение массива, на которое тоже тратятся ресурсы)
//а при работе с LinkedList'oм всегда создается новый узел и на него ссылается тот, что был последним ранее

//добавление по индексу в ArrayList будет медленее, чем аналогичная операция в LinkedList'e,
//ибо после добавления в ArrayList'e по индексу, производится смещение всех элементов от добавленого вправо на одну позицию

//удаление элемента из ArrayList'a производится медленее, чем аналогичная операция в LinkedList'e,
//ибо после удаления в ArrayList'e, производится смещение всех элементов от удаленного влево на одну позицию

//операция получения элемента из ArrayList'a быстрее, чем а аналогичная операция в LinkedList'e,
//ибо при в случае с ArrayList'oм идет прямое обращщение по индексу, а при работе с  LinkedList'oм нужно обходить либо с начала либо с конца до нужного элемента

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(0);
        list.add(1);
        list.add(3);
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        list.remove(0);
        System.out.println(list);
    }
}

//LinkedList односвязный

class MyLinkedList {
    private Node head;
    private int size;

    public void remove(int index){
        int currentIndex = 0;
        Node temp = head;
        if (index == 0){
            head = head.getNext();
            size--;
            return;
        }

        while (temp!=null){
            if(currentIndex == (index-1)){
                temp.setNext(temp.getNext().getNext());
                size--;
                return;
            }else{
                temp = temp.getNext();
                currentIndex++;
            }
        }
    }

    public int get(int index){
        int currentIndex = 0;
        Node temp = head;

        while(temp!=null){
            if (currentIndex == index){
                return temp.getValue();
            }else{
                temp=temp.getNext();
                currentIndex++;
            }
        }

        throw new IllegalStateException();
    }

    public void add(int value) {
        //если это первое добавление в лист
        if (head == null) {
            this.head = new Node(value);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));
        }
        size++;
    }

    @Override
    public String toString() {
        int[] result = new int[size];
        int index = 0;
        Node temp = head;

        while (temp != null) {
            result[index++] = temp.getValue();
            temp = temp.getNext();
        }
        return Arrays.toString(result);
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}