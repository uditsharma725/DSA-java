import java.util.*;

public class qWildcardMatching {

    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n+1][m+1];

        dp[0][0] = true;
        for(int i=1; i<=n; i++) dp[i][0] = false;
        for(int j=1; j<=m; j++) {
            if(p.charAt(j-1) == '*') dp[0][j] = dp[0][j-1];
            else dp[0][j] = false;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
                dp[i][j] = dp[i-1][j-1];

                else if(p.charAt(j-1) == '*') {
                    boolean word = dp[i-1][j];
                    boolean ignore = dp[i][j-1];

                    dp[i][j] = (ignore || word);
                }

                else dp[i][j] = false;
            }
        }

        return dp[n][m];
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        try {

            String s = "baaabab";
            String p = "*****ba*****ab";

            System.out.print(isMatch(s, p));

        } finally {
            sc.close();
        }

    }
}