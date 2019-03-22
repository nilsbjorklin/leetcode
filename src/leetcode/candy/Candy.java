package leetcode.candy;

public class Candy {
    private int[] candies;

    public int candy(int[] ratings) {
        candies = new int[ratings.length];
        int numberOfCandies = 0;
        for (int i = 0; i < ratings.length; i++) {
            if (candies[i] == 0)
                getCandiesForPosition(i, ratings);
            numberOfCandies += candies[i];
        }
        return numberOfCandies;
    }

    void getCandiesForPosition(int position, int[] ratings) {
        int leftRating = position != 0 ? ratings[position - 1] : Integer.MAX_VALUE;
        int rightRating = position != ratings.length - 1 ? ratings[position + 1] : Integer.MAX_VALUE;
        int currentRating = ratings[position];
        int numberOfCandy = 1;
        if (leftRating < currentRating) {
            int leftCandy = candies[position - 1];
            if (leftCandy == 0) {
                getCandiesForPosition(position - 1, ratings);
                leftCandy = candies[position - 1];
            }
            numberOfCandy = leftCandy + 1;
        }
        if (rightRating < currentRating) {
            int rigthCandy = candies[position + 1];
            if (rigthCandy == 0) {
                getCandiesForPosition(position + 1, ratings);
                rigthCandy = candies[position + 1];
            }
            numberOfCandy = Math.max(rigthCandy + 1, numberOfCandy);
        }
        candies[position] = numberOfCandy;
    }
}