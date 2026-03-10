package string.medium;

import java.util.Stack;

public class simplifyPath30 {
    public static String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] parts = path.split("/");

        for (String part : parts) {

            if (part.equals("") || part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }

        StringBuilder result = new StringBuilder();

        for (String dir : stack) {
            result.append("/").append(dir);
        }

        if (result.length() == 0) {
            return "/";
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String path1 = "/home/";
        String path2 = "/home//foo/";
        String path3 = "/home/user/Documents/../Pictures";
        String path4 = "/../";
        String path5 = "/.../a/../b/c/../d/./";

        System.out.println("Input: " + path1);
        System.out.println("Output: " + simplifyPath(path1));

        System.out.println("Input: " + path2);
        System.out.println("Output: " + simplifyPath(path2));

        System.out.println("Input: " + path3);
        System.out.println("Output: " + simplifyPath(path3));

        System.out.println("Input: " + path4);
        System.out.println("Output: " + simplifyPath(path4));

        System.out.println("Input: " + path5);
        System.out.println("Output: " + simplifyPath(path5));
    }
}