package LeetCodeSolutions;

// https://leetcode-cn.com/problems/edit-distance/
public class lc72_EditDistance {
    int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // Initialization
        for (int i = 1; i <= m; i++)
            dp[i][0] = i;
        for (int j = 1; j <= n; j++)
            dp[0][j] = j;
        // DP
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = min(
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1,
                            dp[i-1][j-1] + 1
                    );
        return dp[m][n];
    }

    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
