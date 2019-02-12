package leetcode.valid_parentheses;
import java.util.Stack;
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            switch(sArr[i]){
                case '(':
                case '{':
                case '[':
                    stack.push(sArr[i]);
                break;
                case ')':
                if (stack.empty() || stack.pop() != '(') {
                    return false;
                }
                break;
                case '}':
                if (stack.empty() || stack.pop() != '{') {
                    return false;
                }
                break;
                case ']':
                if (stack.empty() || stack.pop() != '[') {
                    return false;
                }
                break;
            }
        }
        return stack.empty();
    }
}