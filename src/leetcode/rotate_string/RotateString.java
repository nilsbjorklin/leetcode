package leetcode.rotate_string;

public class RotateString {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length())
            return false;
        for (int i = 1; i < A.length(); i++) {
            boolean matches = true;
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt((j + i) % A.length())) {
                    matches = false;
                    j = A.length();
                }
            }
            if (matches)
                return true;
        }
        return A.equals(B);
    }
}