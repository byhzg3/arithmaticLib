package 买卖股票的最佳时机;

/**
 * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 */
public class n714 {
    public static void main(String[] args) {
        System.out.println(new n714().maxProfit(new int[]{4,5,2,4,3,3,1,2,5,4}, 1));
    }
    public int maxProfit(int[] prices, int fee) {
        int record=prices[0],flag =0,sum=0;
        for (int i=1;i<prices.length;i++){
            if (flag==0){
                if (prices[i]<=record){
                    record=prices[i];
                }else if (prices[i]>record+fee){
                    sum+=prices[i]-record-fee;
                    flag=1;
                    record= prices[i];
                }
            }else{
                if (prices[i]>=record){
                    sum+=prices[i]-record;
                    record=prices[i];
                }else if (record>prices[i]+fee){
                    flag=0;
                    record=prices[i];
                }

            }
        }
        return sum;
    }
}
