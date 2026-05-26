package string.easy;

public class crawlerLogFolder104 {

    public int minOperations(String[] logs) {
        int depth = 0;

        for (String op : logs) {
            if (op.equals("../")) {
                if (depth > 0) {
                    depth--;
                }
            } else if (!op.equals("./")) {
                depth++;
            }
        }

        return depth;
    }

    public static void main(String[] args) {
        crawlerLogFolder104 obj = new crawlerLogFolder104();

        String[] logs1 = {"d1/", "d2/", "../", "d21/", "./"};
        System.out.println(obj.minOperations(logs1));

        String[] logs2 = {"d1/", "d2/", "./", "d3/", "../", "d31/"};
        System.out.println(obj.minOperations(logs2));

        String[] logs3 = {"d1/", "../", "../", "../"};
        System.out.println(obj.minOperations(logs3));
    }
}