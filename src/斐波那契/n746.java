package 斐波那契;

public class n746 {
    public static void main(String[] args) {
        int[] a= new int[]{10,15,20};
        System.out.println(minCostClimbingStairs(a));
    }
    public static int minCostClimbingStairs(int[] cost) {
        if (cost==null || cost.length<2)
            return 0;
        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i=2;i<=cost.length;i++){
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}
