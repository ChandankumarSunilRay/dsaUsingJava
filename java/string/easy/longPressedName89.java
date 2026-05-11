package string.easy;

public class longPressedName89 {

    public boolean isLongPressedName(String name, String typed) {

        int i = 0;
        int j = 0;

        while (i < name.length() && j < typed.length()) {

            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            }

            else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            }


            else {
                return false;
            }
        }


        while (j < typed.length()) {

            if (typed.charAt(j) != typed.charAt(j - 1)) {
                return false;
            }

            j++;
        }

        return i == name.length();
    }

    public static void main(String[] args) {

        longPressedName89 obj = new longPressedName89();

        String name1 = "alex";
        String typed1 = "aaleex";

        System.out.println(
                "Example 1 Output: " +
                        obj.isLongPressedName(name1, typed1)
        );

        String name2 = "saeed";
        String typed2 = "ssaaedd";

        System.out.println(
                "Example 2 Output: " +
                        obj.isLongPressedName(name2, typed2)
        );
    }
}