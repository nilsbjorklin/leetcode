package leetcode.first_missing_positive;

import java.util.Arrays;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int currentNumber = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > currentNumber) {
                return currentNumber;
            } else if(nums[i] == currentNumber){
                currentNumber++;
            }
        }
        return currentNumber;
    }
}