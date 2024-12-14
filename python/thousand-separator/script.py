from unittest import TestCase


class Solution:
    def thousandSeparator(self, n: int) -> str:
        if n < 1000:
            return str(n)
        s = str(n)
        return '.'.join([s[::-1][i:i + 3] for i in range(0, len(s), 3)])[::-1]


class Test(TestCase):
    def test_1(self):
        self.assertEqual('987', Solution().thousandSeparator(987))

    def test_2(self):
        self.assertEqual("1.234", Solution().thousandSeparator(1234))

    def test_3(self):
        self.assertEqual("123.456.789", Solution().thousandSeparator(123456789))
