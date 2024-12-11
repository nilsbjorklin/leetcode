package leetcode.power_of_four;

public class PowerOfFour {
    public boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        } else if (n < 1 || n % 4 != 0) {
            return false;
        }
        return isPowerOfFour(n / 4);
    }
}