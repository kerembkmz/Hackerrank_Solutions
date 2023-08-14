import java.util.HashSet;
import java.util.*;

public class InterviewTemplate {

    // Main method for testing and running the code
    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            boolean wordA =  isUniqueCharsA(word);
            boolean wordB =  isUniqueCharsB(word);
            if (wordA == wordB) {
                System.out.println(word + ": " + wordA);
            } else {
                System.out.println(word + ": " + wordA + " vs " + wordB);
            }
        }
    }

    
    public static boolean isUniqueCharsA(String word) {
        //Using data structures & algorithms
        HashSet<String> setOfWord = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            String character = String.valueOf(word.charAt(i));
            setOfWord.add(character);
        }
        if (setOfWord.size() == word.length()){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isUniqueCharsB(String word) {
    // Without using data structures & algorithms
    int startPosition = 0;
    int endingPosition = word.length() - 1;

    while (startPosition < endingPosition) {
        Character startChar = word.charAt(startPosition);
        Character lastChar = word.charAt(endingPosition);

        if (word.charAt(startPosition + 1) == startChar || word.charAt(endingPosition - 1) == lastChar) {
            return false;
        }

        startPosition += 1;
        endingPosition -= 1;
    }
    return true;
    }

    
}