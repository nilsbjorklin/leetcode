package leetcode.find_the_duplicate_number;

import java.util.Arrays;

public class FindTheDuplicateNumber{
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int lastNumber = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == lastNumber) {
                return lastNumber;
            }
            lastNumber = nums[i];
        }
        return 0;
    }
}