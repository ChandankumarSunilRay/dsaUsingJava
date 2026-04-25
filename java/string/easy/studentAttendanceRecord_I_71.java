package string.easy;

public class studentAttendanceRecord_I_71 {

    public boolean checkRecord(String s) {
        int absences = 0;
        int lateStreak = 0;

        for (char c : s.toCharArray()) {
            if (c == 'A') {
                absences++;
                if (absences >= 2) return false;
                lateStreak = 0;
            } else if (c == 'L') {
                lateStreak++;
                if (lateStreak >= 3) return false;
            } else {
                lateStreak = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        studentAttendanceRecord_I_71 obj = new studentAttendanceRecord_I_71();

        String s1 = "PPALLP";
        String s2 = "PPALLL";
        String s3 = "PAPLP";

        System.out.println("Input: " + s1 + " -> Output: " + obj.checkRecord(s1));
        System.out.println("Input: " + s2 + " -> Output: " + obj.checkRecord(s2));
        System.out.println("Input: " + s3 + " -> Output: " + obj.checkRecord(s3));
    }
}




