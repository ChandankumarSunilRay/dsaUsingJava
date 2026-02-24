package EasyProblems;
public class findtheTownJudge41 {
    public static int findJudge(int n, int[][] trust) {
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];

        for (int[] t : trust) {
            out[t[0]]++;
            in[t[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (out[i] == 0 && in[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int n1 = 2;
        int[][] trust1 = {{1, 2}};
        System.out.println("Judge (Example 1): " + findJudge(n1, trust1));

        int n2 = 3;
        int[][] trust2 = {{1, 3}, {2, 3}};
        System.out.println("Judge (Example 2): " + findJudge(n2, trust2));

        int n3 = 3;
        int[][] trust3 = {{1, 3}, {2, 3}, {3, 1}};
        System.out.println("Judge (Example 3): " + findJudge(n3, trust3));
    }
}
