package leetcode.jump_game_2;

public class JumpGame2 {
    private long[] lowestStepsTo;

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        lowestStepsTo = new long[nums.length];
        lowestStepsTo[0] = 0;
        for (int i = 1; i < lowestStepsTo.length; i++) {
            lowestStepsTo[i] = Integer.MAX_VALUE;
        }
        jumpFromPosition(nums, 0);
        return (int) lowestStepsTo[nums.length - 1];
    }

    private void jumpFromPosition(int[] nums, int currentPosition) {
        int longestJumpPossible = nums[currentPosition] + currentPosition;
        if (longestJumpPossible >= nums.length -1) {
            longestJumpPossible = nums.length - 1;
            lowestStepsTo[longestJumpPossible] = lowestStepsTo[currentPosition] + 1;
        } else {
            for (int i = currentPosition + 1; i <= longestJumpPossible; i++) {
                if (lowestStepsTo[i] > lowestStepsTo[currentPosition] + 1
                        && lowestStepsTo[nums.length - 1] > lowestStepsTo[currentPosition] + 2) {
                    lowestStepsTo[i] = lowestStepsTo[currentPosition] + 1;
                }
            }            
            for (int i = longestJumpPossible; i >= currentPosition + 1; i--) {
                if (lowestStepsTo[i] == lowestStepsTo[currentPosition] + 1
                && lowestStepsTo[nums.length - 1] > lowestStepsTo[currentPosition] + 2) {
                    jumpFromPosition(nums, i);
                }
            }
        }
    }
}