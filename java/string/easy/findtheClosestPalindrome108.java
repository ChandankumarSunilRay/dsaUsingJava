package string.easy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class findtheClosestPalindrome108 {

    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        int len = n.length();

        Set<Long> candidates = new HashSet<>();
        candidates.add((long) Math.pow(10, len) + 1);
        candidates.add((long) Math.pow(10, len - 1) - 1);

        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));

        for (long i = prefix - 1; i <= prefix + 1; i++) {
            candidates.add(buildPalindrome(i, len % 2 == 1));
        }

        candidates.remove(num);

        long answer = -1;

        for (long candidate : candidates) {
            if (answer == -1) {
                answer = candidate;
                continue;
            }

            long currentDiff = Math.abs(candidate - num);
            long bestDiff = Math.abs(answer - num);

            if (currentDiff < bestDiff ||
                    (currentDiff == bestDiff && candidate < answer)) {
                answer = candidate;
            }
        }

        return String.valueOf(answer);
    }

    private long buildPalindrome(long prefix, boolean oddLength) {
        long result = prefix;

        if (oddLength) {
            prefix /= 10;
        }

        while (prefix > 0) {
            result = result * 10 + prefix % 10;
            prefix /= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();

        findtheClosestPalindrome108 solution = new findtheClosestPalindrome108();
        System.out.println(solution.nearestPalindromic(n));

        sc.close();
    }
}