import java.util.*;

public class qKnapsackMemo {

    public static int knapsack(int val[], int wt[], int W, int n, int dp[][]) {
        if(n == 0 || W == 0) return 0;

        if(dp[n][W] != -1) return dp[n][W];

        if(wt[n-1] <= W) {
            int ans1 = val[n-1] + knapsack(val, wt, W-wt[n-1], n-1, dp);
            int ans2 = knapsack(val, wt, W, n-1, dp);

            return dp[n][W] = Math.max(ans1, ans2);
        }

        return dp[n][W] = knapsack(val, wt, W, n-1, dp);
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        try {

            int val[] = {15, 14, 10 ,45, 30};
            int wt[] = {2, 5, 1, 3, 4};
            int W = 7;

            int dp[][] = new int[val.length+1][W+1];
            for(int i=0; i<dp.length; i++) {
                for(int j=0; j<dp[i].length; j++) {
                    dp[i][j] = -1;
                }
            }

            System.out.print(knapsack(val, wt, W, val.length, dp));

        } finally {
            sc.close();
        }

    }
}