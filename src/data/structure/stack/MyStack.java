package data.structure.stack;

import java.util.ArrayList;

public class MyStack<T> {
    private ArrayList<T> myStack = new ArrayList<T>();

    public void push(T item){
        myStack.add(item);
    }

    public T pop(){
        if(myStack.isEmpty()) return null;
        return myStack.remove(myStack.size()-1);
    }

}
