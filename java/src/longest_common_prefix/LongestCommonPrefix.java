package leetcode.longest_common_prefix;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int shortestWord = Integer.MAX_VALUE;
        if (strs.length == 1) {
            return strs[0];
        }
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < shortestWord) {
                shortestWord = strs[i].length();
            }
        }
        StringBuilder prefix = new StringBuilder();
        char currentChar = ' ';
        for (int i = 0; i < shortestWord; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (j == 0)
                    currentChar = strs[j].charAt(i);
                else if (currentChar != strs[j].charAt(i)) {
                    return prefix.toString();
                } else if (j == strs.length - 1) {
                    prefix.append(currentChar);
                }
            }
        }
        return prefix.toString();
    }
}