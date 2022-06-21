package 买卖股票的最佳时机;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class h123 {
    public int maxProfit(int[] prices) {
        int[] arr = new int[6];
        arr[0]=0;
        int offset = 0,min=prices[0],max=0;
        for (int i = 1 ; i < prices.length;i++){
            if (prices[i]<=min){
                min=prices[i];
                if (max==0){
                    arr[offset]=i;
                }else{
                    if (offset==5){
                        offset=4;
                    }else{
                        offset=2;
                    }
                }
            }else{
                if (prices[i]>max){
                    offset++;
                    arr[offset]=i;
                }
            }
        }
        /*
        初始化1 2 3 4
        todo:
        (1) 1 2 3 4 5
        (2) 1 2 3 4 5 6
        5>4
            1235
        else
            6_3+2_1 > 2_1 + 4_3 ==> 1236
            6_5+4_3 > 2_1 + 4_3 ==> 3456
            6_5+2_1 > 2_1 + 4_3 ==> 1256
         */
        if (arr[2]!=0){
            return arr[3]+arr[1]-arr[2]-arr[0];
        }else{
            return arr[1]-arr[0];
        }
        return 0;
    }
    public void adjustArr(int[] arr, int[] prices,?){

    }
}
