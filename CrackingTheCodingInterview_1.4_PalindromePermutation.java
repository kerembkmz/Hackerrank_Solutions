import java.util.HashSet;
import java.util.HashMap;
import java.util.*;

/*

Cracking the coding interview, Interview Questions 1.4

Palindrome Permutation: Given a string, write a function 
to check if it is a permutation of a palindrome. A
palindrome is a word or phrase that is the same forwards 
and backwards. A permutation is a rearrangement of letters.
The plaindrome does not need to be limited to just dictionary
words.

EXAMPLE

Input: Tact Coa
Output: True(permutations: "taco cat", "atco, cta", etc.)


Hints: #106, #121, #134, #136
_________________________________________________________

--Mind Dump--

* My first thought was, if the string is a permutation of 
a palindrome, the number of odd letters should be even. 
When a table is created with the current number of letters
& the letters, using charArray, we should be able to create
the string from the ground up. Then to check, we can reverse
the string we created, and check using equals() method.


Then I first realized that if the odd number value is not 
even, it cannot be a palindrome.

I have implemented this but some tests were wrong, so
I realized the odd letter count should be <= 1.

Lastly I changed the code that special characters and 
special characters like , are not counted into the code.
*/


import java.util.*;

public class InterviewTemplate {

    public static void main(String[] args) {
        String[] strings = {"Rats live on no evil star",
                            "A man, a plan, a canal, panama",
                            "Lleve",
                            "Tacotac",
                            "asda"};
        for (String s : strings) {
            
            
            boolean boolVal = isPermutationOfPalindrome(s);  
            System.out.println(s);
            if (boolVal){
                System.out.println("True");
            }
            else{
                System.out.println("False");
            }
        }

    }
    public static boolean isPermutationOfPalindrome(String word){
        
        String strippedWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
        char[] charArray = strippedWord.toCharArray();
        int length = charArray.length;
        int singleLetterCounter = 0;
        
        //letter, corresponding value
        HashMap<Character, Integer> chars = new HashMap<>();
        for (char a : charArray){
            chars.put(a , chars.getOrDefault(a, 0)+1);
        }

        for (int value : chars.values()){
            if (value % 2 == 1){
                singleLetterCounter += 1;
            }
        }

        return singleLetterCounter <= 1;

    }
    
}

    







       
