package data.structure.queue;

import java.util.ArrayList;

public class MyQueue<T> {
    private ArrayList<T> queue = new ArrayList<T>();

    //queue 에 삽입
    public void enqueue(T item){
        queue.add(item);
    }

    //queue 출력
    public T dequeue(){
        if(queue.isEmpty()) return null; //비어있으면 null 리턴
        return queue.remove(0);
    }

    //queue 가 비었는지
    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
