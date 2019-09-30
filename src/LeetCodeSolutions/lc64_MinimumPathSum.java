package LeetCodeSolutions;

public class lc64_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;

        int[][] dp = grid;

        // state transaction function
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // initialization
                // Do not forget continue!
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[0][0];
                    continue;
                }
                if (i == 0){
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                    continue;
                }
                if (j == 0){
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                    continue;
                }

                // normal
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                System.out.println("i = " + i + " j = " + j + " DP = " +dp[i][j]);
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] grids = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grids[i][j] = 1;
            }
        }
        lc64_MinimumPathSum lc64 = new lc64_MinimumPathSum();
        System.out.println(lc64.minPathSum(grids));
    }
}
