package string.easy;

public class maximumScoreWordsFormedbyLetters131 {

    private int[][] wordCount;
    private int[] wordScore;
    private int maxScore;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {

        int n = words.length;

        int[] available = new int[26];
        for (char ch : letters) {
            available[ch - 'a']++;
        }

        wordCount = new int[n][26];
        wordScore = new int[n];

        for (int i = 0; i < n; i++) {
            int currScore = 0;

            for (char ch : words[i].toCharArray()) {
                int idx = ch - 'a';
                wordCount[i][idx]++;
                currScore += score[idx];
            }

            wordScore[i] = currScore;
        }

        maxScore = 0;
        backtrack(0, available, 0, n);

        return maxScore;
    }

    private void backtrack(int index, int[] available, int currentScore, int n) {

        if (index == n) {
            maxScore = Math.max(maxScore, currentScore);
            return;
        }

        backtrack(index + 1, available, currentScore, n);

        boolean canTake = true;

        for (int i = 0; i < 26; i++) {
            if (wordCount[index][i] > available[i]) {
                canTake = false;
                break;
            }
        }

        if (canTake) {

            for (int i = 0; i < 26; i++) {
                available[i] -= wordCount[index][i];
            }

            backtrack(
                    index + 1,
                    available,
                    currentScore + wordScore[index],
                    n
            );

            for (int i = 0; i < 26; i++) {
                available[i] += wordCount[index][i];
            }
        }
    }

    public static void main(String[] args) {

        maximumScoreWordsFormedbyLetters131 obj =
                new maximumScoreWordsFormedbyLetters131();

        String[] words = {"dog", "cat", "dad", "good"};

        char[] letters = {
                'a', 'a', 'c', 'd', 'd', 'd',
                'g', 'o', 'o'
        };

        int[] score = {
                1, 0, 9, 5, 0, 0, 3, 0, 0, 0,
                0, 0, 0, 0, 2, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0
        };

        int result = obj.maxScoreWords(words, letters, score);

        System.out.println("Maximum Score = " + result);
    }
}