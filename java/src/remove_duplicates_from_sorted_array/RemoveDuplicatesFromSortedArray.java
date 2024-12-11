package leetcode.remove_duplicates_from_sorted_array;

public class RemoveDuplicatesFromSortedArray{
    public int removeDuplicates(int[] nums) {
        int counter = 1;
        if(nums.length == 0)
            return 0;
        int currentNumber = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != currentNumber){
                currentNumber = nums[i];
                nums[counter] = currentNumber;
                counter++;
            }
        }
        return counter;
    }
}