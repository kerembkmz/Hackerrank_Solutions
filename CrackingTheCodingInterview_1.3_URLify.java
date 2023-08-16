import java.util.HashSet;
import java.util.HashMap;
import java.util.*;

/*

Cracking the coding interview, Interview Questions 1.3

URLify: Write a method to replace all spaces in a string
 with '%20'. You may assume that the string has sufficient
 splace at the end to hold the additional characters, and
 that you are given the "true" length of the string.
 (Note: If implementing in Java, please use a character 
 array so that you can perform this operation in place.)

Example
Input: "Mr John Smith    " , 13
Output: "Mr%20John%20Smith"

Hints: #53, #118
_________________________________________________________

--Mind Dump--

* Since the questions says there is sufficient space for 
the additional characters (the "%20" 's) ,I will try 
to strip the string from both sides first, then simply 
use replace method for replacing every " " with %20.

! My initial solution was wrong, because I have missed
the part of the question that says it should be an in-place
operation. replaceAll() return a new string.
 
Used Hint #53: IT's often easiest to modify strings by going
from end to beginning.

*/


import java.util.*;

public class InterviewTemplate {
    public static void main(String[] args) {
        String str = "Mr John Smith    "; // 13

        char[] charArray = str.toCharArray();
        char[] charArray2 = new char[charArray.length];

        int globalCounter = charArray.length - 1;
        int counterOfArray2 = charArray.length - 1;
        boolean endingWhiteSpacesAreDone = false;

        for (int i = globalCounter; i >= 0; i--) {
            if (!endingWhiteSpacesAreDone) {
                if (Character.isLetter(charArray[i])) {
                    charArray2[counterOfArray2] = charArray[i];
                    counterOfArray2 -= 1;
                    endingWhiteSpacesAreDone = true;
                }
            } else {
                if (Character.isLetter(charArray[i])) {
                    charArray2[counterOfArray2] = charArray[i];
                    counterOfArray2 -= 1;
                } else if (Character.isWhitespace(charArray[i])) {
                    charArray2[counterOfArray2] = '0';
                    charArray2[counterOfArray2 - 1] = '2';
                    charArray2[counterOfArray2 - 2] = '%';
                    counterOfArray2 -= 3;
                }
            }
        }

        String str2 = new String(charArray2);
        System.out.println(str2);
    }
    //My inital solution
    public static String replaceSpaces(String word){
        String word1 = word.trim();
        String word2 = word1.replaceAll(" ", "%20");
        return word2;
    }
}

    







       
