package string.hard;

import java.util.*;

public class prefixAndSufffixSearch55 {
    static class WordFilter {
        private Map<String, Integer> map;

        public WordFilter(String[] words) {
            map = new HashMap<>();

            for (int index = 0; index < words.length; index++) {
                String word = words[index];
                int n = word.length();

                for (int i = 0; i <= n; i++) {
                    String suffix = word.substring(i);
                    for (int j = 0; j <= n; j++) {
                        String prefix = word.substring(0, j);
                        map.put(suffix + "#" + prefix, index);
                    }
                }
            }
        }

        public int f(String pref, String suff) {
            return map.getOrDefault(suff + "#" + pref, -1);
        }
    }

    public static void main(String[] args) {

        String[] words = {"apple", "banana", "grape"};

        WordFilter wf = new WordFilter(words);

        System.out.println("Query: prefix='a', suffix='e'");
        System.out.println("Result: " + wf.f("a", "e"));

        System.out.println("\nQuery: prefix='b', suffix='a'");
        System.out.println("Result: " + wf.f("b", "a"));

        System.out.println("\nQuery: prefix='gr', suffix='pe'");
        System.out.println("Result: " + wf.f("gr", "pe"));

        System.out.println("\nQuery: prefix='x', suffix='z'");
        System.out.println("Result: " + wf.f("x", "z"));
    }
}






