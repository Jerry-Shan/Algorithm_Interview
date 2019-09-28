package LeetCodeSolutions;

public class lc53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        int [] dp = new int[len];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i<len;i++){
            dp[i] = (dp[i-1]+nums[i] > nums[i]) ? dp[i-1]+nums[i] : nums[i];
            if (dp[i]>max)
                max = dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,1,-3,4,5};
        lc53_MaximumSubarray lc53 = new lc53_MaximumSubarray();
        System.out.println(lc53.maxSubArray(nums));
    }
}
