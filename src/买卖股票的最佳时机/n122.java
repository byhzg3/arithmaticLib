package 买卖股票的最佳时机;

/**
 * 给定一个数组 prices ，其中prices[i] 表示股票第 i 天的价格。
 *
 * 在每一天，你可能会决定购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class n122 {
    public int maxProfit(int[] prices) {
        int profit=0, min  = prices[0];
        for (int i =1;i<prices.length;i++){
            if (min<prices[i]){
                profit+=prices[i]-min;
            }
            min=prices[i];
        }
        return profit;
    }
}
