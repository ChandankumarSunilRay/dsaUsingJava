package string.easy;

public class numberOfDaysBetweenTwoDates87 {

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(convertToDays(date1) - convertToDays(date2));
    }
    private int convertToDays(String date) {

        String[] arr = date.split("-");

        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);

        int[] daysInMonth = {
                31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31
        };

        int totalDays = 0;

        for (int y = 1971; y < year; y++) {
            totalDays += isLeap(y) ? 366 : 365;
        }

        for (int m = 1; m < month; m++) {
            totalDays += daysInMonth[m - 1];

            if (m == 2 && isLeap(year)) {
                totalDays++;
            }
        }

        totalDays += day;
        return totalDays;
    }

    private boolean isLeap(int year) {
        return (year % 400 == 0) ||
                (year % 4 == 0 && year % 100 != 0);
    }
    public static void main(String[] args) {

        numberOfDaysBetweenTwoDates87 obj =
                new numberOfDaysBetweenTwoDates87();

        String date1 = "2019-06-29";
        String date2 = "2019-06-30";

        int result = obj.daysBetweenDates(date1, date2);

        System.out.println("Days Between Dates: " + result);
    }
}