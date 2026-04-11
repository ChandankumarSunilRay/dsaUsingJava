package string.hard;

import java.util.*;

public class namingAcompany66 {

    public long distinctNames(String[] ideas) {
        HashSet<String>[] groups = new HashSet[26];
        for (int i = 0; i < 26; i++) {
            groups[i] = new HashSet<>();
        }

        for (String idea : ideas) {
            int idx = idea.charAt(0) - 'a';
            groups[idx].add(idea.substring(1));
        }

        long result = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                int common = 0;
                for (String suffix : groups[i]) {
                    if (groups[j].contains(suffix)) {
                        common++;
                    }
                }
                int uniqueI = groups[i].size() - common;
                int uniqueJ = groups[j].size() - common;

                result += (long) uniqueI * uniqueJ * 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        namingAcompany66 obj = new namingAcompany66();

        String[] ideas1 = {"coffee", "donuts", "time", "toffee"};
        long result1 = obj.distinctNames(ideas1);
        System.out.println("Output 1: " + result1);

        String[] ideas2 = {"lack", "back"};
        long result2 = obj.distinctNames(ideas2);
        System.out.println("Output 2: " + result2);

        String[] ideas3 = {"apple", "apply", "bpple", "bpply"};
        long result3 = obj.distinctNames(ideas3);
        System.out.println("Output 3: " + result3);
    }
}