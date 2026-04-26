package string.easy;

public class toLowerCase73 {

    public String toLowerCase(String s) {
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                result.append((char)(c + 32));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        toLowerCase73 obj = new toLowerCase73();

        String input = "HeLLo JAVA";
        System.out.println("Output: " + obj.toLowerCase(input));
    }
}