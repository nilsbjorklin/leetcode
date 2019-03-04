package leetcode.basic_calculator;

public class BasicCalculator {
    public int calculate(String s) {
        int modifier = 1;
        char[] arr = s.toCharArray();
        int sum = 0;
        int currentNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                currentNumber *= 10;
                currentNumber += arr[i] - 48;
            } else {
                sum += currentNumber * modifier;
                currentNumber = 0;
                if (arr[i] == '-')
                    modifier = -1;
                if (arr[i] == '+')
                    modifier = 1;
                if (arr[i] == '(') {
                    int parenthesises = 1;
                    int start = i + 1;
                    while (parenthesises != 0) {
                        i++;
                        if (arr[i] == '(')
                            parenthesises++;
                        if (arr[i] == ')')
                            parenthesises--;
                    }
                    currentNumber += calculate(s.substring(start, i));
                }
            }
        }
        sum += currentNumber * modifier;
        return sum;
    }
}