package LeetCodeSolutions;

public class lc322_CoinChange {
    // e.g. coins = [1, 2, 5], amount = 11
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        if (len == 0 || amount<0)
            return -1;
        if (amount==0)
            return 0;
        int [] dp = new int[amount+1];
        for (int i = 0; i <= amount; i++){
            dp[i] = -1;
        }
        for (int i = 0; i< len;i++){
            if(coins[i] == amount)
                return 1;
            if(coins[i] < amount)
                dp[coins[i]] = 1;
        }
        // State Transfer Function
        for(int i = 1; i <= amount;i++){
            for (int j = 0; j < len; j++){
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1){
                    if (dp[i] == -1 || dp[i] > dp[i - coins[j]] + 1){
                        dp[i] = dp[i - coins[j]] + 1;
                    }
                }
            }
        }
        return dp[amount];
    }

//    [1,2147483647]
    public static void main(String[] args) {
        lc322_CoinChange lc322 = new lc322_CoinChange();
        int []coins = {2,2147483643};
        int amount = 4;
        int res = lc322.coinChange(coins,amount);
        System.out.println(res);
    }
}
