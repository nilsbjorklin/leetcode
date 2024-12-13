from collections import deque
from typing import List
from unittest import TestCase


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        index_map = {num: idx for idx, num in enumerate(nums)}
        nums_deque = deque(sorted(nums))
        first = nums_deque.popleft()
        last = nums_deque.pop()
        print(first, last)
        while True:
            total = first + last
            if total == target:
                if first == last:
                    return [i for i, num in enumerate(nums) if num == first]
                return [index_map[first], index_map[last]]
            elif total > target:
                last = nums_deque.pop()
            else:
                first = nums_deque.popleft()


class Test(TestCase):
    def test_1(self):
        self.assertEqual([0, 1], Solution().twoSum([2, 7, 11, 15], 9))

    def test_2(self):
        self.assertEqual([1, 2], Solution().twoSum([3, 2, 4], 6))

    def test_3(self):
        self.assertEqual([0, 1], Solution().twoSum([3, 3], 6))
