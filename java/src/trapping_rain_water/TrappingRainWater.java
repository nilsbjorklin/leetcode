package leetcode.trapping_rain_water;

public class TrappingRainWater {
    public int trap(int[] height) {
        int water = 0, start = 0, end = height.length - 1, leftH = 0, rightH = 0;
        while (start < end) {
            leftH = Math.max(height[start], leftH);
            rightH = Math.max(height[end], rightH);
            String map = "";
            for (int i = 0; i < height.length; i++) {
                if (i == start || i == end)
                    map += "[";
                map += height[i];
                if (i == start || i == end)
                    map += "]";
                map += ",";
            }
            if (leftH <= rightH) {
                water += Math.max(leftH - height[start + 1], 0);
                start++;
            } else {
                water += Math.max(rightH - height[end - 1], 0);
                end--;
            }
        }
        return water;
    }
}