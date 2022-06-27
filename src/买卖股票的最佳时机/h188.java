package 买卖股票的最佳时机;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class h188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length>0 && k>0){
            int[] buy = new int[k];
            int[] sell = new int[k];
            for (int i =0;i<k;i++){
                buy[i]=-prices[0];
            }
            for (int i =1;i < prices.length;i++){
                buy[0]=Math.max(buy[0],-prices[i]);
                sell[0]=Math.max(sell[0],prices[i]+buy[0]);
                for (int j=1;j<k;j++){
                    buy[j]=Math.max(buy[j],sell[j-1]-prices[i]);
                    sell[j]=Math.max(sell[j],buy[j]+prices[i]);
                }
            }
            return sell[k-1];
        }
        return 0;
    }
}
