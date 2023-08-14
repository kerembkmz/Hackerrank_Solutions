import java.util.HashSet;
import java.util.HashMap;
import java.util.*;

/*

Cracking the coding interview, Interview Questions 1.2

--Mind Dump--
Hint #122 -> Could a hash table work? 
 - Yes, this was my initial solution, counting the 
 number of occurance of each character in both strings, 
 then comparing them. 

Hint #131 -> Two strings that are permutations should
have the same characters, but in different orders,
can you make the orders same?

 - Yes, very smart solution, instead of checking the
 characters, if we just convert them to arrays,
 in order to sort, then we can just sort and return
 if they are equal or not. 




*/


public class InterviewTemplate {

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean outputs = permutationA(word1, word2);
            boolean outputs2 = permutationB(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + outputs);
            System.out.println(word1 + ", " + word2 + ": " + outputs2);
            System.out.println("-------------------------------------");
        }
    }


    public static boolean permutationA(String word1, String word2){
        if (word1.length() != word2.length()){
            return false;
        }

        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();

        for (char c : word1.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c,0) + 1);
        }

        for (char c1 : word2.toCharArray()) {
            if (!charMap.containsKey(c1) || charMap.get(c1) == 0){
                return false;
            }
            else {
                charMap.put(c1, charMap.get(c1) - 1);
            }
        }
        return true;
    }

    //The method below is done by hint #131 in the book.
    public static boolean permutationB(String word1, String word2) {
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();

        Arrays.sort(word1Array);
        Arrays.sort(word2Array);

        return Arrays.equals(word1Array, word2Array);
    }
}
       
