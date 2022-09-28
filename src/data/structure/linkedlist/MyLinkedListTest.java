package data.structure.linkedlist;

public class MyLinkedListTest {
    public static void main(String[] args) {
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
    }


}
