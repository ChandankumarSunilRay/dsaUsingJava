package string.hard;

import java.util.*;

public class textJustification41 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i;
            int lineLength = 0;

            while (j < words.length && lineLength + words[j].length() + (j - i) <= maxWidth) {
                lineLength += words[j].length();
                j++;
            }

            int numberOfWords = j - i;
            int totalSpaces = maxWidth - lineLength;

            StringBuilder line = new StringBuilder();

            if (j == words.length || numberOfWords == 1) {

                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) line.append(" ");
                }

                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {

                int spacesPerGap = totalSpaces / (numberOfWords - 1);
                int extraSpaces = totalSpaces % (numberOfWords - 1);

                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k < j - 1) {
                        int spaces = spacesPerGap + (extraSpaces > 0 ? 1 : 0);

                        for (int s = 0; s < spaces; s++) {
                            line.append(" ");
                        }

                        if (extraSpaces > 0) extraSpaces--;
                    }
                }
            }
            result.add(line.toString());
            i = j;
        }
        return result;
    }


    public static void main(String[] args) {
        textJustification41 obj = new textJustification41();

        String[] words = {
                "This", "is", "an", "example", "of", "text", "justification."
        };
        int maxWidth = 16;

        List<String> result = obj.fullJustify(words, maxWidth);

        System.out.println("Formatted Text:\n");
        for (String line : result) {
            System.out.println("|" + line + "|");
        }
    }
}