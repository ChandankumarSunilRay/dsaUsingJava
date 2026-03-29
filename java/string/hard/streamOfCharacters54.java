package string.hard;

import java.util.*;

public class streamOfCharacters54 {

    static class StreamChecker {

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isWord = false;
        }

        private TrieNode root;
        private StringBuilder stream;
        private int maxLen;

        public StreamChecker(String[] words) {
            root = new TrieNode();
            stream = new StringBuilder();
            maxLen = 0;

            for (String word : words) {
                maxLen = Math.max(maxLen, word.length());
                insertReverse(word);
            }
        }

        private void insertReverse(String word) {
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                int idx = c - 'a';

                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.isWord = true;
        }

        public boolean query(char letter) {
            stream.append(letter);

            TrieNode node = root;

            for (int i = stream.length() - 1, count = 0;
                 i >= 0 && count < maxLen;
                 i--, count++) {

                char c = stream.charAt(i);
                int idx = c - 'a';

                if (node.children[idx] == null) {
                    return false;
                }

                node = node.children[idx];

                if (node.isWord) {
                    return true;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        String[] words = {"cd", "f", "kl"};
        StreamChecker sc = new StreamChecker(words);

        char[] queries = {'a','b','c','d','e','f','g','h','i','j','k','l'};

        for (char ch : queries) {
            boolean result = sc.query(ch);
            System.out.println("query('" + ch + "') -> " + result);
        }
    }
}
