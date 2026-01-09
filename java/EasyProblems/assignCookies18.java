package EasyProblems;

import java.util.Arrays;

public class assignCookies18 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        int count = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        assignCookies18 solution = new assignCookies18();

        int[] g1 = {1, 2, 3};
        int[] s1 = {1, 1};
        System.out.println("Output: " + solution.findContentChildren(g1, s1));

        int[] g2 = {1, 2};
        int[] s2 = {1, 2, 3};
        System.out.println("Output: " + solution.findContentChildren(g2, s2));
    }
}
