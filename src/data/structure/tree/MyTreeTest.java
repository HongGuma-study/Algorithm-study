package data.structure.tree;

public class MyTreeTest {
    public static void main(String[] args) {
        MyTree myTree = new MyTree();
        myTree.insertNode(1);
        myTree.insertNode(2);
        myTree.insertNode(3);
        myTree.insertNode(4);
        myTree.insertNode(5);
        myTree.insertNode(6);
        myTree.insertNode(7);
        System.out.println(myTree.search(2).right.value);
    }
}
