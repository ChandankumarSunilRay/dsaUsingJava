package string.easy;

import java.util.*;

public class reformatDate91 {

    public static String reformatDate(String date) {

        String[] parts = date.split(" ");

        String day = parts[0].replaceAll("[a-zA-Z]", "");
        if (day.length() == 1) {
            day = "0" + day;
        }

        Map<String, String> monthMap = new HashMap<>();
        monthMap.put("Jan", "01");
        monthMap.put("Feb", "02");
        monthMap.put("Mar", "03");
        monthMap.put("Apr", "04");
        monthMap.put("May", "05");
        monthMap.put("Jun", "06");
        monthMap.put("Jul", "07");
        monthMap.put("Aug", "08");
        monthMap.put("Sep", "09");
        monthMap.put("Oct", "10");
        monthMap.put("Nov", "11");
        monthMap.put("Dec", "12");

        String month = monthMap.get(parts[1]);
        String year = parts[2];

        return year + "-" + month + "-" + day;
    }

    public static void main(String[] args) {

        String date1 = "20th Oct 2052";
        String date2 = "6th Jun 1933";
        String date3 = "26th May 1960";

        System.out.println(reformatDate(date1));
        System.out.println(reformatDate(date2));
        System.out.println(reformatDate(date3));
    }
}