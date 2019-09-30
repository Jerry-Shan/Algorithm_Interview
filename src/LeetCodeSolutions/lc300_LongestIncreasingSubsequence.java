package LeetCodeSolutions;

public class lc300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int [] dp = new int[len]; // when index = i, the length of longest increasing subsequence
        dp [0] = 1;
        int max = dp[0];
        for (int i = 0; i < len; i++){
            dp[i] = 1;
            for(int j = 0; j < i;j++){
                if(nums[i] > nums[j] && dp[i] < dp[j]+1)
                    dp[i] = dp[j]+1;
            }
            if(dp[i]>max)
                max = dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int [] nums = {10,9,2,5,3,7,101,18};
        lc300_LongestIncreasingSubsequence lis = new lc300_LongestIncreasingSubsequence();
        System.out.println(lis.lengthOfLIS(nums));
    }
}
