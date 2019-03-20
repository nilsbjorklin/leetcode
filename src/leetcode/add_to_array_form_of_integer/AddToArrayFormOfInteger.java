package leetcode.add_to_array_form_of_integer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        char[] kString = Integer.toString(K).toCharArray();
        int[] B = new int[kString.length];
        for (int i = 0; i < kString.length; i++) {
            B[i] = kString[i] - '0';
        }
        return addArrays(A, B);
    }

    public List<Integer> addArrays(int[] A, int[] B) {
        List<Integer> result = new ArrayList<>();
        int carry = 0, counter = 1;
        while (carry != 0 || counter <= A.length || counter <= B.length) {
            int sum = carry + (counter <= A.length ? A[A.length - counter]: 0) + (counter <= B.length ? B[B.length - counter] : 0);
            result.add(sum % 10);
            carry = sum / 10;
            counter++;
        }
        Collections.reverse(result);
        return result;
    }
}