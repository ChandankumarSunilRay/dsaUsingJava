package string.easy;

import java.util.Scanner;

public class dayOfTheYear93 {

    public int dayOfYear(String date) {

        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            days[1] = 29;
        }

        int totalDays = 0;

        for (int i = 0; i < month - 1; i++) {
            totalDays += days[i];
        }

        totalDays += day;

        return totalDays;
    }

    public static void main(String[] args) {

        dayOfTheYear93 obj = new dayOfTheYear93();

        String[] testDates = {
                "2019-01-09",
                "2019-02-10",
                "2020-03-01",
                "2024-12-31",
                "2000-02-29"
        };

        System.out.println("Predefined Test Cases:");
        System.out.println("----------------------");

        for (String date : testDates) {
            System.out.println(date + " -> Day Number: " + obj.dayOfYear(date));
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter a date (YYYY-MM-DD): ");
        String userDate = sc.nextLine();

        int result = obj.dayOfYear(userDate);

        System.out.println(userDate + " is day number " + result + " of the year.");

        sc.close();
    }
}