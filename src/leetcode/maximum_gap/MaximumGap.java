package leetcode.maximum_gap;

import java.util.Arrays;

public class MaximumGap {
    public int maximumGap(int[] nums) {
        int maximumGap = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > maximumGap)
                maximumGap = nums[i] - nums[i - 1];
        }
        return maximumGap;
    }
}