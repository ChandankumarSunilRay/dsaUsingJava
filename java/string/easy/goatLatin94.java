package string.easy;

public class goatLatin94 {

    public String toGoatLatin(String sentence) {

        String[] words = sentence.split(" ");
        String vowels = "aeiouAEIOU";

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            String word = words[i];


            if (vowels.indexOf(word.charAt(0)) != -1) {
                word = word + "ma";
            } else {

                word = word.substring(1) + word.charAt(0) + "ma";
            }
            for (int j = 0; j <= i; j++) {
                word += "a";
            }

            result.append(word);

            if (i != words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        goatLatin94 obj = new goatLatin94();

        String sentence1 = "I speak Goat Latin";
        String sentence2 = "The quick brown fox jumped over the lazy dog";

        System.out.println("Input  : " + sentence1);
        System.out.println("Output : " + obj.toGoatLatin(sentence1));

        System.out.println();

        System.out.println("Input  : " + sentence2);
        System.out.println("Output : " + obj.toGoatLatin(sentence2));
    }
}
