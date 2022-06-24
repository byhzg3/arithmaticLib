package 买卖股票的最佳时机;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class h123 {
    public static void main(String[] args) {
        System.out.println(new h123().maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0}));
    }

    public int maxProfit(int[] prices) {
        int[] indexs = new int[]{0, -1, -1, -1, -1};
        int offset = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int tail = prices[indexs[offset]];
            if (offset % 2 == 0) {
                if (prices[i] <= min) {
                    indexs[offset] = i;
                    min = prices[i];
                } else if (indexs[offset] != -1 && prices[i] > tail) {
                    //是进，还是调整
                    if (offset == 0) {
                        offset = 1;
                        indexs[1] = i;
                        min = 0x7fffffff;
                    }
                    if (offset == 2) {
                        offset = 3;
                        indexs[3] = i;
                        min = 0x7fffffff;
                    }
                    if (offset == 4) {
                        int i1_0 = prices[indexs[1]] - prices[indexs[0]];
                        int i3_2 = prices[indexs[3]] - prices[indexs[2]];
                        int i3_0 = prices[indexs[3]] - prices[indexs[0]];
                        int i3210 = i3_2+i1_0;
                        int i5210 = prices[i] - prices[indexs[2]] + i1_0;
                        int i5432 = prices[i] - prices[indexs[4]] + i3_2;
                        int i5410 = prices[i] - prices[indexs[4]] + i1_0;
                        int i5430 = prices[i] - prices[indexs[4]] + i3_0;
                        int max = Math.max(i3210,i5210);
                        max=Math.max(max,i5432);
                        max=Math.max(max,i5410);
                        max=Math.max(max,i5430);
                        if (i5210 == max) {
                            indexs[3] = i;
                            indexs[4] = -1;
                            min = 0x7fffffff;
                            offset = 3;
                        } else if (i5432 == max) {
                            indexs[0] = indexs[2];
                            indexs[1] = indexs[3];
                            indexs[2] = indexs[4];
                            indexs[3] = i;
                            indexs[4] = -1;
                            min = 0x7fffffff;
                            offset = 3;
                        } else if (i5410 == max) {
                            indexs[2] = indexs[4];
                            indexs[3] = i;
                            indexs[4] = -1;
                            min = 0x7fffffff;
                            offset = 3;
                        } else if (i5430 == max){
                            indexs[1]= indexs[3];
                            indexs[2] = indexs[4];
                            indexs[3] = i;
                            indexs[4] = -1;
                            min = 0x7fffffff;
                            offset = 3;
                        }
                    }
                }
            } else {
                if (prices[i] > tail) {
                    indexs[offset] = i;
                    min = prices[i];
                } else if (prices[i] < tail) {
                    offset++;
                    indexs[offset] = i;
                    min = prices[i];
                }
                //奇数
            }
        }
        if (indexs[1]==-1){
            return 0;
        }
        if (indexs[3] == -1) {
            return prices[indexs[1]] - prices[indexs[0]];
        } else {
            return prices[indexs[3]] - prices[indexs[2]] + prices[indexs[1]] - prices[indexs[0]];
        }
        /*
        初始化1 2 3 4
        ///

          2
          2   4
          2 3 4
        1 2 3 4
        ///
        todo:
                    i
        (1) 0 1 2 3 4

                      i
        (2) 0 1 2 3 4 5
        4>3
            0124
        else
            5_2+1_0 > 1_0 + 3_2 ==> 0125
            5_4+3_2 > 1_0 + 3_2 ==> 2345
            5_4+1_0 > 1_0 + 3_2 ==> 0145
            5_4+3_0 > 1_0 + 3_2 ==> 0345
         */

    }
}
