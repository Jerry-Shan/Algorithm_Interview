package LeetCodeSolutions;

public class lc174_DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0)
            return 0;
        int row = dungeon.length;
        int col = dungeon[0].length;

        int[][] dp = dungeon;
        int dp_min = 0;

        // state transaction function
        for (int i = row-1; i >=0; i--) {
            for (int j = col-1; j >=0 ; j--) {
                // initialization
                // Do not forget continue!
                if (i == row-1 && j == col-1) {
                    dp[i][j] = Math.max(1,1-dungeon[i][j]);
                    continue;
                }
                if (i == row-1 ){
                    dp[i][j] = Math.max(1,dp[i][j+1]-dungeon[i][j]);
                    continue;
                }
                if (j == col-1){
                    dp[i][j] = Math.max(1,dp[i+1][j]-dungeon[i][j]);
                    continue;
                }

                // normal
                dp_min= Math.min(dp[i][j+1], dp[i+1][j]);
                dp[i][j] = Math.max(1,dp_min-dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        int[][] grids = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grids[i][j] = 1;
            }
        }
        lc174_DungeonGame lc174 = new lc174_DungeonGame();
        System.out.println(lc174.calculateMinimumHP(grids));
    }
}
