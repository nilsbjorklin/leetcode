package leetcode.equal_rational_numbers;

import java.util.ArrayList;
import java.util.List;

public class EqualRationalNumbers {
    public boolean isRationalEqual(String S, String T) {
        int longest = Math.max(S.length() - 2, T.length() - 2);
        String first = generateOfLength(S, longest);
        String second = generateOfLength(T, longest);
        return first.matches(second + "0*") || second.matches(first + "0*");
    }

    private String generateOfLength(String number, int length) {
        String[] parts = number.split("[()]");
        String firstPart[] = parts[0].split("\\.");
        int prefix = Integer.parseInt(firstPart[0]);
        String suffix = (firstPart.length == 2 && firstPart[0].length() != 0) ? firstPart[1] : "";
        double suffixAsDouble = (firstPart.length == 2 && firstPart[0].length() != 0)
                ? Double.parseDouble("." + firstPart[1])
                : 0;
        String repeating = parts.length == 2 ? parts[1] : "";
        if (repeating.length() == 0 || repeating.matches("9+")) {
            if (repeating.length() != 0) {
                int modifier = (firstPart.length == 2 ? firstPart[1].length() : 0);
                suffixAsDouble += Math.pow(10, -1 * modifier);
            }
            return Double.toString(suffixAsDouble + prefix);
        } else {
            StringBuilder suffixBuilder = new StringBuilder(prefix + "." + suffix);
            while (suffixBuilder.length() < length) {
                suffixBuilder.append(repeating);
            }
            return suffixBuilder.toString().substring(0, length);
        }
    }

    public boolean test() {
        List<TestCase> tests = new ArrayList<>();
        tests.add(new TestCase("1.9(0)", "1.8(9)", true));
        tests.add(new TestCase("1.001(01)", "1.00(10)", true));
        tests.add(new TestCase("0.9(9)", "1.", true));
        tests.add(new TestCase("0.08(9)", "0.09", true));
        tests.add(new TestCase("0.9(9)", "1.", true));
        tests.add(new TestCase("0.(52)", "0.5(25)", true));
        int failedCount = 0;
        for (TestCase test : tests) {
            if (!test.runTest()) {
                System.err.printf("Test failed got: \"%s\" expected \"%s\"%nInput: (\"%s\", \"%s\")%n%n",
                        !test.condition, test.condition, test.S, test.T);
                failedCount++;
            }
        }
        if (failedCount != 0) {
            System.err.printf("%d test%s failed, %d total.", failedCount, failedCount == 1 ? "" : "s", tests.size());
            return false;
        } else {
            System.out.printf("%d out of %d tests passed.", tests.size() - failedCount, tests.size());
            return true;
        }
    }

    class TestCase {
        String S;
        String T;
        boolean condition;

        TestCase(String S, String T, boolean condition) {
            this.S = S;
            this.T = T;
            this.condition = condition;
        }

        boolean runTest() {
            return isRationalEqual(S, T) == condition;
        }
    }
}