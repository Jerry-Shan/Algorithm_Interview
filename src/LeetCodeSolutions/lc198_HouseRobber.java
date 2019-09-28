/*
198. House Robber
https://leetcode.com/problems/house-robber/
Given a list of non-negative integers representing the amount of money of each house,
determine the maximum amount of money you can rob tonight without alerting the police.
it will automatically contact the police if two adjacent houses were broken into on the same night.
*/

package LeetCodeSolutions;

public class lc198_HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        if(nums.length < 2)
            return nums[0];
        dp[1] = (nums[0]>nums[1]) ? nums[0] : nums[1];
        for(int i = 2;i<nums.length;i++)
            dp[i] = ((nums[i] + dp[i-2]) > dp[i-1]) ? (nums[i]+dp[i-2]) : dp[i-1];
        return dp[nums.length-1];
    }
}
