package algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {

    public ArrayList<Integer> sort(ArrayList<Integer> dataList){
        for(int index = 0; index < dataList.size(); index++){
            boolean swap = false;

            for(int idx = 2; idx<dataList.size(); idx++){

                if(dataList.get(idx) > dataList.get(idx+1)){
                    Collections.swap(dataList, idx, idx+1);
                    swap = true;
                }
            }

            if(!swap){
                break;
            }
        }


        return dataList;
    }
}
