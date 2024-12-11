package leetcode.plus_one;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        boolean carry = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            carry = digits[i] == 9;
            if (carry) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        if(carry){
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            Arrays.fill(result, 1, digits.length, 0);
            return result;
        }
        return digits;
    }
}