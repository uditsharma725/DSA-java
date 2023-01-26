import java.util.*;

public class fibonacciTab {

    public static int fib(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        try {

            int n = 25;
            System.out.print(fib(n));

        } finally {
            sc.close();
        }

    }
}