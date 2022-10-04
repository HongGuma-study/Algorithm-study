package data.structure.heap;

public class MyHeapTest {
    public static void main(String[] args) {
        MyHeap myHeap = new MyHeap(1);
        System.out.println(myHeap.heapArray);
        myHeap.insert(2);
        myHeap.insert(3);
        myHeap.insert(4);
        myHeap.insert(5);
        System.out.println(myHeap.heapArray);
        myHeap.insert(20);
        myHeap.insert(12);
        myHeap.insert(11);
        System.out.println(myHeap.heapArray);
        System.out.println(myHeap.pop());
        System.out.println(myHeap.heapArray);
        System.out.println(myHeap.pop());
        System.out.println(myHeap.heapArray);
        System.out.println(myHeap.pop());
        System.out.println(myHeap.heapArray);
        System.out.println(myHeap.pop());
        System.out.println(myHeap.heapArray);
    }
}
