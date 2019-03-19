package leetcode.maximum_subarray;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0], toCurrent = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (toCurrent < 0)
                toCurrent = nums[i];
            else
                toCurrent += nums[i];
                
            if (toCurrent > max)
                max = toCurrent;
        }
        return max;
    }
}