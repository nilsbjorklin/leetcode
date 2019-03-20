package leetcode.merge_interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeInterval {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);
        Interval last = null;
        for (Interval interval : intervals) {
            if (last == null) {
                last = interval;
            } else if (last.end < interval.start) {
                result.add(last);
                last = interval;
            } else {
                last.end = Math.max(last.end, interval.end);
            }
        }
        if (last == null)
            return intervals;
        result.add(last);
        return result;
    }
}