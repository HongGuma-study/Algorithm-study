package algorithm.greedy;

import java.util.Arrays;

/**
 * 부분 배낭 문제
 * 무게 제한이 k인 배낭에 최대 가치를 가지도록 물건을 넣는 문제
 * 각 물건은 무게(w)와 가치(v)로 표현될 수 있음
 * 물건은 쪼갤 수 있으므로 물건의 일부분이 배낭에 넣어질 수 있음
 *
 *  물건(i)   물건1 물건2 물건3 물건4 물건5
 *  무게(w)    10   15   20    25   30
 *  가치(v)    10   12   10    8    5
 *
 */
public class FractionalKnapsackProblem {
    public static void main(String[] args) {

    }
    public static void packFunc(){
        Integer[][] objectList = {{10,10},{15,12},{20,10},{25,8},{30,5}};

        //정렬 기준 정의하기 : 정렬을 위해서는 정렬 기준이 있어야 함

        Integer[] iArray = new Integer[]{1,10,4,3,2};
        Arrays.sort(iArray);
        Arrays.toString(iArray);
    }

}


