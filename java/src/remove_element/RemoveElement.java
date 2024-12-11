package leetcode.remove_element;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int counter = 0;
        for (int cur : nums) {
            if (cur != val) {
                nums[counter] = cur;
                counter++;
            }
        }
        return counter;
    }
}