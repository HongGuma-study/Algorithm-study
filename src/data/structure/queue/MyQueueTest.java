package data.structure.queue;

public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue<Integer> mq = new MyQueue<Integer>();
        mq.enqueue(1);
        mq.enqueue(2);
        mq.enqueue(3);
        mq.enqueue(43);
        // 1,2,3 넣은 순서대로 출력된다.
        System.out.println(mq.dequeue()); //1
        System.out.println(mq.dequeue()); //2
        System.out.println(mq.dequeue()); //3

    }
}
