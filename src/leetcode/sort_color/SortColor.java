package leetcode.sort_color;

public class SortColor {
    public void sortColors(int[] nums) {
        int[] colors = {0, 0, 0};
        for (int num : nums) {
            colors[num]++;
        }
        int color = 0;
        for (int i = 0; i < nums.length; i++) {
            while(colors[color] == 0){
                color++;
            }
            nums[i] = color;
            colors[color]--;
        }
    }
}
