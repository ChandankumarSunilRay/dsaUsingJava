package string.easy;

import java.util.*;

public class wordBreakII111 {

    private Map<Integer, List<String>> memo;
    private Set<String> dict;
    private String s;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.dict = new HashSet<>(wordDict);
        this.memo = new HashMap<>();

        return dfs(0);
    }

    private List<String> dfs(int start) {

        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> result = new ArrayList<>();


        if (start == s.length()) {
            result.add("");
            return result;
        }

        for (int end = start + 1; end <= s.length(); end++) {

            String word = s.substring(start, end);

            if (!dict.contains(word)) {
                continue;
            }

            List<String> suffixSentences = dfs(end);

            for (String sentence : suffixSentences) {

                if (sentence.isEmpty()) {
                    result.add(word);
                } else {
                    result.add(word + " " + sentence);
                }
            }
        }

        memo.put(start, result);
        return result;
    }

    public static void main(String[] args) {

        wordBreakII111 solution = new wordBreakII111();

        String s = "catsanddog";

        List<String> wordDict = Arrays.asList(
                "cat",
                "cats",
                "and",
                "sand",
                "dog"
        );

        List<String> answer = solution.wordBreak(s, wordDict);

        System.out.println("Possible Sentences:");
        for (String sentence : answer) {
            System.out.println(sentence);
        }
    }
}