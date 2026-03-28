package string.hard;

import java.util.HashSet;
import java.util.Set;

public class crackingTheSafe53 {

    public String crackSafe(int n, int k) {
        StringBuilder result = new StringBuilder();
        Set<String> visited = new HashSet<>();

        String start = "";
        for (int i = 0; i < n - 1; i++) {
            start += "0";
        }

        dfs(start, k, visited, result);

        result.append(start);
        return result.toString();
    }

    private void dfs(String node, int k, Set<String> visited, StringBuilder result) {
        for (int i = 0; i < k; i++) {
            String edge = node + i;

            if (!visited.contains(edge)) {
                visited.add(edge);

                dfs(edge.substring(1), k, visited, result);

                result.append(i);
            }
        }
    }

    public static void main(String[] args) {
        crackingTheSafe53 obj = new crackingTheSafe53();

        int n = 2;
        int k = 2;

        String result = obj.crackSafe(n, k);

        System.out.println("Result: " + result);
        System.out.println("Length: " + result.length());
    }
}