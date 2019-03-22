package leetcode.single_number_II;

import java.util.Arrays;

public class SingleNumberII {
    int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 3) {
            if (nums[i] != nums[i + 1] || nums[i] != nums[i + 2])
                return nums[i];
        }
        return nums[nums.length - 1];
    }
}
