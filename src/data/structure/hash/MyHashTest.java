package data.structure.hash;

public class MyHashTest {
    public static void main(String[] args) {
        MyHash myhash = new MyHash(20);
        myhash.saveData("DaveLee","111111");
        myhash.saveData("Kim","222222");
        myhash.saveData("David","333333");
        myhash.saveData("Dave","444444");
        System.out.println(myhash.getData("Dave"));

    }
}
