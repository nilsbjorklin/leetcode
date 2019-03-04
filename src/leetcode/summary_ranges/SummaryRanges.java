package leetcode.summary_ranges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        StringBuilder result = new StringBuilder();
        if (nums.length == 0)
            return new ArrayList<String>();
        int lastNumber = nums[0], start = nums[0];
        result.append(start);
        for (int i = 1; i < nums.length; i++) {
            String current = result.toString();
            if (nums[i] != lastNumber + 1) {
                if (lastNumber != start)
                    result.append("->" + lastNumber);
                result.append(",");
                start = nums[i];
                result.append(start);
            }
            lastNumber = nums[i];
        }
        if (lastNumber != start)
            result.append("->" + lastNumber);
        return Arrays.asList(result.toString().split(","));
    }
}