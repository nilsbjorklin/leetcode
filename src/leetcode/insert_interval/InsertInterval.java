package leetcode.insert_interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> resultervals = new ArrayList<>();
        boolean done = false;
        for (Interval interval : intervals) {
            if (done) {
                resultervals.add(interval);
                continue;
            }
            if (interval.start > newInterval.end || interval.end < newInterval.start) {
                if (interval.start > newInterval.end) {
                    done = true;
                    resultervals.add(newInterval);
                    resultervals.add(interval);
                } else {
                    resultervals.add(interval);
                }
                continue;
            }
            if (interval.start < newInterval.start)
                newInterval.start = interval.start;
            if (interval.end > newInterval.end)
                newInterval.end = interval.end;
        }
        if (!done)
            resultervals.add(newInterval);
        return resultervals;
    }
}