package string.hard;

import java.util.Stack;

public class tagValidator51 {

    public boolean isValid(String code) {
        int i = 0, n = code.length();
        Stack<String> stack = new Stack<>();

        while (i < n) {

            if (i > 0 && stack.isEmpty()) return false;

            if (i + 9 < n && code.startsWith("<![CDATA[", i)) {
                int j = code.indexOf("]]>", i);
                if (j == -1) return false;
                i = j + 3;
            }

            else if (i + 2 < n && code.startsWith("</", i)) {
                int j = code.indexOf(">", i);
                if (j == -1) return false;

                String tagName = code.substring(i + 2, j);

                if (!isValidTag(tagName)) return false;
                if (stack.isEmpty() || !stack.peek().equals(tagName)) return false;

                stack.pop();
                i = j + 1;
            }

            else if (code.charAt(i) == '<') {
                int j = code.indexOf(">", i);
                if (j == -1) return false;

                String tagName = code.substring(i + 1, j);

                if (!isValidTag(tagName)) return false;

                stack.push(tagName);
                i = j + 1;
            }

            else {
                i++;
            }
        }

        return stack.isEmpty();
    }

    private boolean isValidTag(String tag) {
        if (tag.length() < 1 || tag.length() > 9) return false;

        for (char c : tag.toCharArray()) {
            if (c < 'A' || c > 'Z') return false;
        }

        return true;
    }

    public static void main(String[] args) {
        tagValidator51 validator = new tagValidator51();

        String[] tests = {
                "<DIV>This is the first line <![CDATA[<div>]]></DIV>",
                "<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>",
                "<A>  <B> </A>   </B>",
                "<A></A>",
                "<A><B></B></A>",
                "<A></A><B></B>"
        };

        for (String code : tests) {
            System.out.println("Input: " + code);
            System.out.println("Valid: " + validator.isValid(code));
            System.out.println("-----------");
        }
    }
}
