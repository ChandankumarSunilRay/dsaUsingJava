package string.easy;
public class checkIfaWordOccursAsaPrefixofAnyWordinaSentence143 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        checkIfaWordOccursAsaPrefixofAnyWordinaSentence143 solution =
                new checkIfaWordOccursAsaPrefixofAnyWordinaSentence143();

        String sentence1 = "i love eating burger";
        String searchWord1 = "burg";
        System.out.println("Output: " +
                solution.isPrefixOfWord(sentence1, searchWord1));

        String sentence2 = "this problem is an easy problem";
        String searchWord2 = "pro";
        System.out.println("Output: " +
                solution.isPrefixOfWord(sentence2, searchWord2));

        String sentence3 = "i am tired";
        String searchWord3 = "you";
        System.out.println("Output: " +
                solution.isPrefixOfWord(sentence3, searchWord3));
    }
}