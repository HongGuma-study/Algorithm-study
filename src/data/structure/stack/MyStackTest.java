package data.structure.stack;

import java.util.Stack;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack<Integer> ms = new MyStack<Integer>();

        ms.push(1);
        ms.push(2);
        ms.push(3);
        ms.push(4);
        ms.push(5);
        System.out.println(ms.pop());
        System.out.println(ms.pop());
        System.out.println(ms.pop());
        System.out.println(ms.pop());
    }
}
