package 买卖股票的最佳时机;

/**
 * 给定一个数组 prices ，其中prices[i] 表示股票第 i 天的价格。
 *
 * 在每一天，你可能会决定购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润。
 *
 */
public class n309 {
    public static void main(String[] args) {
        System.out.println(new n309().maxProfit(new int[]{1, 2,3,0,2}));
    }
    public int maxProfit(int[] prices) {
        /*
        买入 卖出 冷冻期 买入 卖出
         */
        int sum = 0;
        boolean freeze = false;
        int[] deal = new int[4];
        deal[0]=-prices[0];
        deal[2]=-prices[0];
        for (int i =1;i<prices.length;i++){
            if (freeze){
                deal[0]=-prices[i];
                deal[2]=-prices[0];
                freeze=false;
                continue;
            }
            //解冻期
            if (prices[i]<deal[3]){
                sum+=deal[3];
                freeze=true;
                deal=new int[4];
            }else{
                deal[0]= Math.max(deal[0],-prices[i]);
                deal[1]= Math.max(deal[1],prices[i]+deal[0]);
                deal[2]= Math.max(deal[2],deal[1]-prices[i]);
                deal[3]= Math.max(deal[3],deal[2]+prices[i]);
            }
        }
        return sum+deal[3];
    }
}
