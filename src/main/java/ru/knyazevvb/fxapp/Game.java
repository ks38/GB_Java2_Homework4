package ru.knyazevvb.fxapp;

import java.util.*;

public class Game {
    public static class BullCowCount {
        private final int bulls;
        private final int cows;

        public BullCowCount(int bulls, int cows) {
            this.bulls = bulls;
            this.cows = cows;
        }

        public int getBulls() {
            return bulls;
        }

        public int getCows() {
            return cows;
        }
    }
    private final int[] guessNumber;

    public Game() {
        this.guessNumber = generateNumber();
        System.out.println(Arrays.toString(guessNumber));
    }

    private int[] generateNumber() {
        final List<Integer> a = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(a);

        return new int[]{a.get(0), a.get(1), a.get(2), a.get(3)};
    }

    public BullCowCount calc(String playerNum) {
        int bulls = 0, cows = 0;
        for (int i = 0; i < 4; i++) {
            if (guessNumber[i] == playerNum.charAt(i) - '0') {
                bulls++;
            } else if(playerNum.contains(String.valueOf(guessNumber[i]))) {
                cows++;
            }
        }
        return new BullCowCount(bulls, cows);
    }

    public String getGuessNumber () {
        return "" + guessNumber[0] + guessNumber[1] + guessNumber[2] + guessNumber[3];
    }
}
