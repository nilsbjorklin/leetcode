package leetcode.collect_fruits;

public class CollectFruits {
    public int totalFruit(int[] tree) {
        int start = 0, position = 1, max = 0, startFruit = tree[0], endFruit = tree[0];
        while (position < tree.length) {
            if (tree[start] != startFruit) {
                startFruit = tree[start];
            }
            if (tree[position] != startFruit) {
                if (startFruit == endFruit) {
                    endFruit = tree[position];
                } else if (endFruit != tree[position]) {
                    max = Math.max(position - start, max);
                    endFruit = tree[position];
                    start = position - 1;
                    startFruit = tree[start];
                    while (startFruit == tree[start - 1] || endFruit == tree[start - 1])
                        start--;
                    continue;
                }
            }
            position++;
        }
        max = Math.max(position - start, max);
        return max;
    }
}