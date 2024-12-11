package leetcode.power_of_three;

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        } else if (n < 1 || n % 3 != 0) {
            return false;
        }
        return isPowerOfThree(n / 3);
    }
}