package ua.od.atomspace;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(2);
        stack.push(1);
        stack.push(3);

        System.out.println(stack.peek());//получаем, но не удаляем
        System.out.println("-");
        System.out.println(stack.pop());//получаем и удаляем
        System.out.println("-");

        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }
}
