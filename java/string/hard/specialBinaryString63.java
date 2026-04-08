package string.hard;

import java.util.*;

public class specialBinaryString63 {

    public String makeLargestSpecial(String s) {
        List<String> list = new ArrayList<>();
        int count = 0, start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
            else count--;

            if (count == 0) {
                String inner = s.substring(start + 1, i);

                String processed = "1" + makeLargestSpecial(inner) + "0";
                list.add(processed);

                start = i + 1;
            }
        }

        Collections.sort(list, Collections.reverseOrder());

        StringBuilder result = new StringBuilder();
        for (String str : list) {
            result.append(str);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        specialBinaryString63 obj = new specialBinaryString63();

        String input1 = "11011000";
        String input2 = "10";

        System.out.println("Input: " + input1);
        System.out.println("Output: " + obj.makeLargestSpecial(input1));

        System.out.println();

        System.out.println("Input: " + input2);
        System.out.println("Output: " + obj.makeLargestSpecial(input2));
    }
}