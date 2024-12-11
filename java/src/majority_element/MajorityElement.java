package leetcode.majority_element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0)
            return result;
        if (nums.length == 1) {
            result.add(nums[0]);
            return result;
        }
        Arrays.sort(nums);
        int threshold = nums.length / 3;
        int lastNumberCount = 1;
        boolean lastValid = false;
        for (int i = 1; i < nums.length; i++) {
            if (!lastValid && lastNumberCount > threshold) {
                lastValid = true;
                result.add(nums[i - 1]);
            }
            if (nums[i] == nums[i - 1]) {
                lastNumberCount++;
            } else {
                lastValid = false;
                lastNumberCount = 1;
            }
        }
        if (!lastValid && lastNumberCount > threshold) {
            result.add(nums[nums.length - 1]);
        }
        return result;
    }
}