package string.hard;

import java.util.*;

interface Master {
    int guess(String word);
}

public class guessTheWord56 {

    static class MasterImpl implements Master {
        private String secret;
        private int attempts = 0;

        public MasterImpl(String secret) {
            this.secret = secret;
        }

        @Override
        public int guess(String word) {
            attempts++;
            int match = 0;

            for (int i = 0; i < 6; i++) {
                if (word.charAt(i) == secret.charAt(i)) {
                    match++;
                }
            }

            System.out.println("Attempt " + attempts + ": " + word + " -> matches: " + match);
            return match;
        }
    }

    public void findSecretWord(String[] words, Master master) {
        List<String> candidates = new ArrayList<>(Arrays.asList(words));

        for (int i = 0; i < 30 && !candidates.isEmpty(); i++) {
            String guess = pickBest(candidates);
            int matches = master.guess(guess);

            if (matches == 6) {
                System.out.println(" Found Secret Word: " + guess);
                return;
            }

            List<String> next = new ArrayList<>();
            for (String w : candidates) {
                if (match(w, guess) == matches) {
                    next.add(w);
                }
            }
            candidates = next;
        }

        System.out.println(" Failed to find the secret word");
    }

    private String pickBest(List<String> words) {
        int minMaxGroup = Integer.MAX_VALUE;
        String best = words.get(0);

        for (String w1 : words) {
            int[] count = new int[7];

            for (String w2 : words) {
                if (w1.equals(w2)) continue;
                int m = match(w1, w2);
                count[m]++;
            }

            int worst = 0;
            for (int c : count) {
                worst = Math.max(worst, c);
            }

            if (worst < minMaxGroup) {
                minMaxGroup = worst;
                best = w1;
            }
        }

        return best;
    }

    private int match(String a, String b) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (a.charAt(i) == b.charAt(i)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        guessTheWord56 solver = new guessTheWord56();

        String[] words = {
                "acckzz", "ccbazz", "eiowzz", "abcczz"
        };

        String secret = "acckzz";

        Master master = new MasterImpl(secret);

        solver.findSecretWord(words, master);
    }
}