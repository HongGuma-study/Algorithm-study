package algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 지불해야 하는 값이 4720원 일 때 1원, 50원, 100원, 500원 동전으로 동전의 수가 가장 적게 지불하시오.
 */
public class CoinProblem {
    public static void main(String[] args) {
        ArrayList<Integer> coinList = new ArrayList<>(Arrays.asList(500,100,50,1));
        coinFunc(4720,coinList);

    }
    public static void coinFunc(Integer price, ArrayList<Integer> coinList){
        Integer totalCoinCount = 0;
        Integer coinNum = 0;
        ArrayList<Integer> details = new ArrayList<Integer>();

        for (int index = 0; index < coinList.size(); index++) {
            coinNum = price/coinList.get(index);
            totalCoinCount += coinNum;
            price -= coinNum * coinList.get(index);
            details.add(coinNum);
            System.out.println(coinList.get(index)+"원 "+coinNum+"개");
        }

        System.out.println("최소 동전 개수 : "+totalCoinCount);
    }



}
