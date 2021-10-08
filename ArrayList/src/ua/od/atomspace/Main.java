package ua.od.atomspace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // под капотом у ArrayList'а находится обычный массив, но в классе прописана логика, что позволяет его удобно испольщовать
        List<Integer> list = new ArrayList<>(3);//ссылку на коллекции надо делать типа интерфейса, что они реализуют,
        // чтобы походу написания можно было пользоваться разными имлементациями интерфейса

        for (int i = 0; i < 5;i++){
            list.add(i);
        }

        // если эррейлист переполнен, а метод add вызывается, то создается новый массив размером в newCapacity = oldCapacity + (oldCapacity >> 1)
        // в новый переносятся все элементы старого и добавляется тот один из метода add

        list.remove(3);//при удалении элемента происходит такая ситуация [0,1,,3,4]
        //элемент под этим индексом удаляется потом происходит сдвиг справа налево [0,1,3,4] и размер массива уменьшается на 1

        // когда нужно производить много удалений из ArrayList'а, то лучше перекинуть все элементы в LinkedList
        list = new LinkedList<Integer>(list);
        System.out.println(list.getClass());//проверка того, что ссылка типа List указывает на объект LinkedList
        System.out.println(list);
    }
}
