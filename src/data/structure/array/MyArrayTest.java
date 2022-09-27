package data.structure.array;

public class MyArrayTest {
    public static void main(String[] args) {
        MyArray array = new MyArray();
        array.addElement(10);
        array.addElement(20);
        array.addElement(30);
        array.insertElement(1,50); //1번 자리에 50 추가하기
        array.printAll();

        System.out.println("===============");
        array.removeElement(1);
        array.printAll();
        System.out.println("===============");

        array.addElement(70);
        array.printAll();
        System.out.println("===============");
        array.removeElement(1);
        array.printAll();

        System.out.println("===============");
        System.out.println(array.getElement(2));
    }
}
