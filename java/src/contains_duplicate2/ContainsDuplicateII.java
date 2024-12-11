package leetcode.contains_duplicate2;

import java.util.HashMap;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Object duplicate = map.put(nums[i], i);
            if (duplicate != null && i - (int) duplicate <= k)
                return true;
        }
        return false;
    }
}