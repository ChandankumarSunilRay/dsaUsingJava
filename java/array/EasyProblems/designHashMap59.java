package EasyProblems;

public class designHashMap59 {
    static class MyHashMap {

        private static class Node {
            int key;
            int value;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private static final int SIZE = 1000;
        private Node[] buckets;

        public MyHashMap() {
            buckets = new Node[SIZE];
        }

        private int hash(int key) {
            return (key & 0x7fffffff) % SIZE;
        }

        public void put(int key, int value) {
            int index = hash(key);
            Node curr = buckets[index];

            if (curr == null) {
                buckets[index] = new Node(key, value);
                return;
            }

            while (true) {
                if (curr.key == key) {
                    curr.value = value;
                    return;
                }
                if (curr.next == null) {
                    curr.next = new Node(key, value);
                    return;
                }
                curr = curr.next;
            }
        }

        public int get(int key) {
            int index = hash(key);
            Node curr = buckets[index];

            while (curr != null) {
                if (curr.key == key) {
                    return curr.value;
                }
                curr = curr.next;
            }
            return -1;
        }

        public void remove(int key) {
            int index = hash(key);
            Node curr = buckets[index];
            Node prev = null;

            while (curr != null) {
                if (curr.key == key) {
                    if (prev == null) {
                        buckets[index] = curr.next;
                    } else {
                        prev.next = curr.next;
                    }
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
        }
    }
    public static void main(String[] args) {

        MyHashMap map = new MyHashMap();

        map.put(1, 10);
        map.put(2, 20);
        map.put(1001, 30);

        System.out.println("Key 1: " + map.get(1));
        System.out.println("Key 2: " + map.get(2));
        System.out.println("Key 1001: " + map.get(1001));
        System.out.println("Key 3: " + map.get(3)); // not present

        map.put(1, 99);
        System.out.println("Updated Key 1: " + map.get(1));

        map.remove(2);
        System.out.println("After removing Key 2: " + map.get(2));
    }
}