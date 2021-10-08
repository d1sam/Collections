package ua.od.atomspace;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        Iterator<Integer> iterator = linkedList.iterator();
        //after java 5
        for (Integer element : linkedList) {// проходясь по элементам коллекции с помощью foreach нельзя изменять структуру коллекции (удалять)
            System.out.println(element);// ибо можно удалить элемент, к которому дальше нужно будет обратиться
        }

        System.out.println("-------");

        int idx=0;
        while (iterator.hasNext()) {
            System.out.println(iterator.next());//удалили второй элемент
            if (idx == 1) {
                iterator.remove();
            }
            idx++;
        }

        System.out.println("-------");

        System.out.println(linkedList);
    }
}
