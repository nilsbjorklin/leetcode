package leetcode.reverse_integer;

public class ReverseInteger {
	public int reverse(int x) {
		int direction = x < 0 ? -1 : 1;
		int i;
		i = (int) (Math.log10((double) x * (double) direction));
		double result = 0;
		while (x != 0) {
			result += (x % 10) * Math.pow(10, i);
			if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
				return 0;
			x = x / 10;
			i--;
		}
		return (int) result;
	}

	public int reverse2(int x) {
		double result = 0;
		while (x != 0) {
			result = result * 10 + (x % 10);
			if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
				return 0;
			x = x / 10;
		}
		return (int) result;
	}
}
