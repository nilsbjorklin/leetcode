package leetcode.first_bad_version;

public class FirstBadVersion {
    int firstBadVersion;
    int start;

    public FirstBadVersion(int firstBadVersion) {
        this.firstBadVersion = firstBadVersion;
        this.start = 1;
    }

    public int firstBadVersion(int n) {
        int pivot = start + (n - start) / 2;
        if (n < start)
            return -1;
        if (isBadVersion(start))
            return start;
        if (isBadVersion(pivot)) {
            return firstBadVersion(pivot);
        } else {
            start = pivot + 1;
            return firstBadVersion(n);
        }
    }

    boolean isBadVersion(int version) {
        return firstBadVersion <= version;
    }
}