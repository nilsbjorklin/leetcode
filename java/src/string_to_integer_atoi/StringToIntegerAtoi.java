package leetcode.string_to_integer_atoi;

public class StringToIntegerAtoi {
    public int myAtoi(String str) {
        char[] charArr = str.trim().toCharArray();
        int modifier = 0;
        StringBuilder sb = new StringBuilder();
        for (char character : charArr) {
            if (Character.isDigit(character)) {
                sb.append(character);
            } else if (sb.toString().isEmpty()) {
                if (character == '-' && modifier == 0)
                    modifier = -1;
                else if (character == '+' && modifier == 0)
                    modifier = 1;
                else
                    return 0;
            } else {
                break;
            }
        }
        if (sb.toString().length() == 0) {
            return 0;
        } else {
            try {
                if (modifier == -1)
                    return -Integer.parseInt(sb.toString());
                else
                    return Integer.parseInt(sb.toString());
            } catch (Exception e) {
                if (modifier == -1)
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }
        }
    }
}