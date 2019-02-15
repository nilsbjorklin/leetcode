package leetcode.count_and_say;

public class CountAndSay {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = recurse(result);
        }
        return result;
    }

    public String recurse(String n) {
        char[] charArray = n.toCharArray();
        char currentNumber = charArray[0];
        int count = 1;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < charArray.length; i++) {
            if (currentNumber == charArray[i]) {
                count++;
            } else {
                result.append(count);
                result.append(currentNumber);
                count = 1;
                currentNumber = charArray[i];
            }
        }
        if (count != 0) {
            result.append(count);
            result.append(currentNumber);            
        }
        return result.toString();
    }
}