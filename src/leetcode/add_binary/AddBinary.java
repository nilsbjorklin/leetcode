package leetcode.add_binary;

import java.util.Stack;

public class AddBinary {
    public String addBinary(String a, String b) {
        Stack<Boolean> aList = StringToStack(a);
        Stack<Boolean> bList = StringToStack(b);
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (!aList.empty() || !bList.empty()) {
            int count = carry;
            if (!aList.empty() && aList.pop()) {
                count++;
            }
            if (!bList.empty() && bList.pop()) {
                count++;
            }
            carry = count > 1 ? 1 : 0;
            sb.append(count % 2);
        }
        if (carry == 1)
            sb.append(1);
        return sb.reverse().toString();
    }

    private Stack<Boolean> StringToStack(String s) {
        Stack<Boolean> result = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                result.add(true);
            else
                result.add(false);
        }
        return result;
    }
}