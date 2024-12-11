package leetcode.valid_number;

public class ValidNumber {
    public boolean isNumber(String s) {
        if (1 == s.length() - s.replace("e", "").length()) {
            String parts[] = s.trim().split("e");
            if (parts.length != 2 || parts[1].contains(".")) {
                return false;
            }
            for (String part : parts) {
                if (!validNumberPart(part))
                    return false;
            }
            return true;
        } else{
            return validNumberPart(s.trim());
        }
    }
    boolean validNumberPart(String part) {
        if (part.isEmpty())
            return false;
        boolean sign = false, point = false;
        int numbers = 0;
        for (int i = 0; i < part.length(); i++) {
            char currentChar = part.charAt(i);
            if (!Character.isDigit(currentChar)) {
                if (!point && currentChar == '.')
                    point = true;
                else if (sign || (currentChar != '+' && currentChar != '-'))
                    return false;
            } else {
                numbers++;
            }
            sign = true;
        }
        return numbers != 0;
    }
}