package data.structure.linkedlist;

public class MyLinkedListTest {
    public static void main(String[] args) {
/*
        SingleLinkedList<Integer> mySingleLinkedList = new SingleLinkedList<Integer>();
        mySingleLinkedList.addNode(1);
        mySingleLinkedList.addNode(2);
        mySingleLinkedList.addNode(3);
        mySingleLinkedList.addNode(4);
        mySingleLinkedList.addNode(5);
        mySingleLinkedList.printAll();
        System.out.println("-");
        mySingleLinkedList.addNodeInside(12,3); //12를 3사이에 넣겠다.
        mySingleLinkedList.printAll();
        System.out.println("-");
        mySingleLinkedList.delNode(1);
        mySingleLinkedList.printAll();
        System.out.println("-");
        mySingleLinkedList.delNode(4);
        mySingleLinkedList.printAll();
*/

        DoubleLinkedList<Integer> myDoubleLinkedList = new DoubleLinkedList<Integer>();
        myDoubleLinkedList.addNode(1);
        myDoubleLinkedList.addNode(2);
        myDoubleLinkedList.addNode(3);
        myDoubleLinkedList.addNode(4);
        myDoubleLinkedList.addNode(5);
        myDoubleLinkedList.printAll();
        System.out.println("-");
        myDoubleLinkedList.insertToFront(4,12); // 4 앞에 12를 넣을 거임
        myDoubleLinkedList.printAll();
        System.out.println("-");
        myDoubleLinkedList.delNode(4);
        myDoubleLinkedList.delNode(5);
        myDoubleLinkedList.printAll();

    }


}
