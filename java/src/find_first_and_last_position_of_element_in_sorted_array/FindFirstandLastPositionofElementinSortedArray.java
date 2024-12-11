package leetcode.find_first_and_last_position_of_element_in_sorted_array;

public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int endOfArray = nums.length - 1;
        if (endOfArray == -1 || nums[0] > target || nums[endOfArray] < target)
            return new int[] { -1, -1 };
        int firstInstance = findFirst(nums, 0, endOfArray, target);
        if (firstInstance == -1)
            return new int[] { -1, -1 };
        return new int[] { firstInstance, findLast(nums, firstInstance, endOfArray, target) };
    }

    private int findFirst(int[] nums, int start, int end, int target) {
        if (start > end)
            return -1;
        int pivot = start + (end - start) / 2;
        if (nums[start] == target)
            return start;
        if (nums[pivot] == target && (pivot == 0 || nums[pivot - 1] != target))
            return pivot;
        if (nums[pivot] < target) {
            return findFirst(nums, pivot + 1, end, target);
        } else if (nums[pivot] >= target) {
            return findFirst(nums, start, pivot - 1, target);
        }
        return -1;
    }

    private int findLast(int[] nums, int start, int end, int target) {
        int pivot = start + (end - start) / 2;
        if (nums[end] == target)
            return end;
        if (nums[pivot] == target && nums[pivot + 1] != target)
            return pivot;
        if (nums[pivot] <= target) {
            return findLast(nums, pivot + 1, end, target);
        } else if (nums[pivot] > target) {
            return findLast(nums, start, pivot - 1, target);
        }
        return -1;
    }
}