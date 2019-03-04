package leetcode.guess_number;

public class GuessNumber {
    int numberToGuess;

    public GuessNumber(int numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    private int guess(int n) {
        if (n == numberToGuess)
            return 0;
        else if (n > numberToGuess)
            return -1;
        return 1;
    }

    public int guessNumber(int n) {
        int result, max = n, min = 1;
        n =  1 + (n - 1) / 2;
        do {
            result = guess(n);
            if(result == -1){
                max = n - 1;
                n = min + (max - min) / 2;
            } else if(result == 1){
                min = n + 1;
                n = min + (max - min) / 2;
            }
        } while (result != 0);
        return n;
    }
}