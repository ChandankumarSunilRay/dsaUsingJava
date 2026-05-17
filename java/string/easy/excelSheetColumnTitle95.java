package string.easy;

public class excelSheetColumnTitle95 {

    public String convertToTitle(int columnNumber) {

        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {

            columnNumber--;

            int remainder = columnNumber % 26;

            result.append((char) ('A' + remainder));

            columnNumber = columnNumber / 26;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {

        excelSheetColumnTitle95 obj = new excelSheetColumnTitle95();

        int n1 = 1;
        int n2 = 28;
        int n3 = 701;

        System.out.println(n1 + " -> " + obj.convertToTitle(n1));
        System.out.println(n2 + " -> " + obj.convertToTitle(n2));
        System.out.println(n3 + " -> " + obj.convertToTitle(n3));
    }
}