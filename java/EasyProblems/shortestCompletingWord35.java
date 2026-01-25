package EasyProblems;

public class shortestCompletingWord35 {

    public static String shortestCompletingWord(String licensePlate, String[] words) {

        int[] required = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                required[Character.toLowerCase(c) - 'a']++;
            }
        }

        String answer = null;

        for (String word : words) {
            int[] count = new int[26];

            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }

            boolean valid = true;
            for (int i = 0; i < 26; i++) {
                if (count[i] < required[i]) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                if (answer == null || word.length() < answer.length()) {
                    answer = word;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        String licensePlate1 = "1s3 PSt";
        String[] words1 = {"step", "steps", "stripe", "stepple"};
        System.out.println(shortestCompletingWord(licensePlate1, words1));

        String licensePlate2 = "1s3 456";
        String[] words2 = {"looks", "pest", "stew", "show"};
        System.out.println(shortestCompletingWord(licensePlate2, words2));
    }
}
