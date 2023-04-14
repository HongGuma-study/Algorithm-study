package algorithm.sort;

import java.util.ArrayList;

public class Split {
    public static void main(String[] args) {

    }

    public void split(ArrayList<Integer> dataList){
        if(dataList.size() <= 1) return;

        int medium = dataList.size()/2;

        ArrayList<Integer> leftArr = new ArrayList<>(dataList.subList(0,medium));
        ArrayList<Integer> rightArr = new ArrayList<>(dataList.subList(medium,dataList.size()-1));




    }

    public ArrayList<Integer> mergeFunc(ArrayList<Integer> dataList){

    }
}
