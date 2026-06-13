package string.easy;

public class excelSheetColumnNumber122 {

    public static int titleToNumber(String columnTitle) {
        int result = 0;

        for (char ch : columnTitle.toCharArray()) {
            result = result * 26 + (ch - 'A' + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] testCases = {"A", "AB", "ZY", "FXSHRXW"};

        for (String column : testCases) {
            System.out.println("Column Title: " + column +
                    " -> Column Number: " +
                    titleToNumber(column));
        }
    }
}