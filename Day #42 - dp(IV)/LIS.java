import java.util.*;

public class LIS {

    public static int lis(int arr1[]) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr1.length; i++) set.add(arr1[i]);

        int i = 0;
        int arr2[] = new int[set.size()];
        for(int num : set) {
            arr2[i] = num;
            i++;
        }

        Arrays.sort(arr2);
        return lcs(arr1, arr2);
    }

    public static int lcs(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;

        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                dp[i][j] = 0;
            }
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(arr1[i-1] == arr2[j-1]) 
                dp[i][j] = dp[i-1][j-1] + 1;

                else {
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];

                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        try {

            int arr[] = {50, 3, 10, 7, 40, 80};
            System.out.print(lis(arr));

        } finally {
            sc.close();
        }

    }
}