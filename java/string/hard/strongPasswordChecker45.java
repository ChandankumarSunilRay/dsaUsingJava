package string.hard;

public class strongPasswordChecker45 {

    public int strongPasswordChecker(String password) {
        int n = password.length();

        boolean hasLower = false, hasUpper = false, hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
        }

        int missingTypes = 0;
        if (!hasLower) missingTypes++;
        if (!hasUpper) missingTypes++;
        if (!hasDigit) missingTypes++;

        int replace = 0;
        int[] repeats = new int[n];

        for (int i = 0; i < n;) {
            int j = i;
            while (i < n && password.charAt(i) == password.charAt(j)) {
                i++;
            }
            repeats[j] = i - j;
        }

        for (int i = 0; i < n; i++) {
            if (repeats[i] >= 3) {
                replace += repeats[i] / 3;
            }
        }

        if (n < 6) {
            return Math.max(missingTypes, 6 - n);
        }

        if (n <= 20) {
            return Math.max(missingTypes, replace);
        }

        int delete = n - 20;
        int remainingDelete = delete;

        for (int k = 1; k <= 2; k++) {
            for (int i = 0; i < n && remainingDelete > 0; i++) {
                if (repeats[i] >= 3 && repeats[i] % 3 == (k - 1)) {
                    int need = k;
                    if (remainingDelete >= need) {
                        repeats[i] -= need;
                        remainingDelete -= need;
                        replace--;
                    }
                }
            }
        }

        for (int i = 0; i < n && remainingDelete > 0; i++) {
            if (repeats[i] >= 3) {
                int need = repeats[i] - 2;
                int used = Math.min(remainingDelete, need);
                repeats[i] -= used;
                remainingDelete -= used;
                replace -= used / 3;
            }
        }

        return delete + Math.max(missingTypes, replace);
    }

    public static void main(String[] args) {
        strongPasswordChecker45 obj = new strongPasswordChecker45();

        String[] testCases = {
                "a",
                "aA1",
                "1337C0d3",
                "aaaaaaaAAAAAA6666bbbbaaaaaaABBC"
        };

        for (String password : testCases) {
            int result = obj.strongPasswordChecker(password);
            System.out.println("Password: " + password + " -> Steps needed: " + result);
        }
    }
}
