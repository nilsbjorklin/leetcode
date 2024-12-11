package leetcode.longest_valid_parentheses;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        char[] arr = s.toCharArray();
        int counter = 0;
        int stack = 0;
        int longest = 0;
        for (int start = 0; start < arr.length; start++) {
            if(arr[start] == '('){
                counter = 0;
                stack = 0;
                for (int i = start; i < arr.length; i++) {
                    if (arr[i] == '(') {
                        stack++;
                    } else {
                        stack--;
                    }
                    counter++;
                    if (stack == 0 && counter > longest)
                        longest = counter;
                    if(stack < 0)
                    i = arr.length;
                }
            }
        }
        return longest;
    }
}