package string.hard;

public class similarStringGroups65 {

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    uf.union(i, j);
                }
            }
        }

        return uf.getCount();
    }

    private boolean isSimilar(String a, String b) {
        int diff = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 2) return false;
            }
        }

        return diff == 0 || diff == 2;
    }

    class UnionFind {
        int[] parent;
        int count;

        public UnionFind(int n) {
            parent = new int[n];
            count = n;

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) {
                parent[pa] = pb;
                count--;
            }
        }
        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        similarStringGroups65 obj = new similarStringGroups65();

        String[] input1 = {"tars", "rats", "arts", "star"};
        System.out.println("Output 1: " + obj.numSimilarGroups(input1));

        String[] input2 = {"omv", "ovm"};
        System.out.println("Output 2: " + obj.numSimilarGroups(input2));
    }
}