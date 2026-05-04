package string.easy;

public class deleteColumnToMakeSorted82 {

    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();
        int count = 0;

        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows - 1; r++) {
                if (strs[r].charAt(c) > strs[r + 1].charAt(c)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        deleteColumnToMakeSorted82 obj = new deleteColumnToMakeSorted82();

        String[] strs1 = {"cba", "daf", "ghi"};
        System.out.println("Output: " + obj.minDeletionSize(strs1));

        String[] strs2 = {"a", "b"};
        System.out.println("Output: " + obj.minDeletionSize(strs2));

        String[] strs3 = {"abc", "bce", "cae"};
        System.out.println("Output: " + obj.minDeletionSize(strs3));
    }
}