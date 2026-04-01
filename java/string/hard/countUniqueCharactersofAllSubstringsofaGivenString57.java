package string.hard;

import java.util.Scanner;

public class countUniqueCharactersofAllSubstringsofaGivenString57 {

    public int uniqueLetterString(String s) {
        int n = s.length();

        int[] prev = new int[n];
        int[] next = new int[n];

        int[] lastSeen = new int[26];

        for (int i = 0; i < 26; i++) lastSeen[i] = -1;

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'A';
            prev[i] = lastSeen[c];
            lastSeen[c] = i;
        }

        for (int i = 0; i < 26; i++) lastSeen[i] = n;

        for (int i = n - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'A';
            next[i] = lastSeen[c];
            lastSeen[c] = i;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += (i - prev[i]) * (next[i] - i);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string (UPPERCASE only): ");
        String input = sc.nextLine();

        countUniqueCharactersofAllSubstringsofaGivenString57 obj =
                new countUniqueCharactersofAllSubstringsofaGivenString57();

        int result = obj.uniqueLetterString(input);

        System.out.println("Result: " + result);

        sc.close();
    }
}




