package EasyProblems;

public class numberOfEquivalentDominoPairs61 {

    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];
        int result = 0;

        for (int[] d : dominoes) {
            int min = Math.min(d[0], d[1]);
            int max = Math.max(d[0], d[1]);

            int key = min * 10 + max;

            result += count[key];

            count[key]++;
        }
        return result;
    }

    public static void main(String[] args) {
        numberOfEquivalentDominoPairs61 solution =
                new numberOfEquivalentDominoPairs61();

        int[][] dominoes1 = {{1,2},{2,1},{3,4},{5,6}};
        System.out.println("Output 1: " +
                solution.numEquivDominoPairs(dominoes1));

        int[][] dominoes2 = {{1,2},{1,2},{1,1},{1,2},{2,2}};
        System.out.println("Output 2: " +
                solution.numEquivDominoPairs(dominoes2));
    }
}