package 买卖股票的最佳时机;

/**
 给定一个整数数组prices，其中prices[i]表示第i天的股票价格 。

 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

 */
public class n309 {
    public static void main(String[] args) {
        System.out.println(new n309().maxProfit(new int[]{1, 2,3,0,2}));
    }

    public int maxProfit(int[] prices) {
        int[][] profitMatrix = new int[prices.length][2];
        int freezeProfit = 0;
        profitMatrix[0][0] = -prices[0]; //持股状态最大收益
        profitMatrix[0][1] = 0; //无持股最大收益
        for (int i = 1; i < prices.length; i++) {
            profitMatrix[i][0] = Math.max(freezeProfit - prices[i], profitMatrix[i - 1][0]);
            profitMatrix[i][1] = Math.max(profitMatrix[i - 1][0] + prices[i], profitMatrix[i - 1][1]);
            freezeProfit = profitMatrix[i - 1][1];
        }
        return profitMatrix[prices.length - 1][1];
    }
}
