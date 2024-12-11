package leetcode.letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {
        return recurse(digits.toCharArray(), 0);
    }

    private List<String> recurse(char[] digits, int index) {
        if (index == digits.length - 1) {
            return getCharsForDigit(digits[index]);
        } else {
            List<String> combinations = new ArrayList<>();

            List<String> nextDigitValues = recurse(digits, index + 1);

            List<String> currentDigitValues = getCharsForDigit(digits[index]);
            for (String currentDigitValue : currentDigitValues) {
                for (String nextDigitValue : nextDigitValues) {
                    combinations.add(currentDigitValue + nextDigitValue);
                }
            }

            return combinations;
        }
    }

    List<String> getCharsForDigit(char digit) {
        switch (digit) {
            case '2':
                return Arrays.asList("a", "b", "c");
            case '3':
                return Arrays.asList("d", "e", "f");
            case '4':
                return Arrays.asList("g", "h", "i");
            case '5':
                return Arrays.asList("j", "k", "l");
            case '6':
                return Arrays.asList("m", "n", "o");
            case '7':
                return Arrays.asList("p", "q", "r", "s");
            case '8':
                return Arrays.asList("t", "u", "v");
            case '9':
                return Arrays.asList("w", "x", "y", "z");
            default:
                return null;
        }
    }
}
