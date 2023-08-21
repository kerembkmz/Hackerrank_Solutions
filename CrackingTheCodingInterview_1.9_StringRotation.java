import java.util.*;



/*

Cracking the coding interview, Interview Questions 1.9

String Rotation: Assume you have a method isSubstring which
checks if one word is a substring of another. Given two
strings, s1 and s2, write code to check if s2 is a rotation 
of s1 using only one call to isSubstring.

Example: "waterbottle" is a rotation of "erbottlewat"


Hints: #34, #88, #104
_________________________________________________________

--Mind Dump--

* I did not understand the question well enough to come up with 
a solution in the first step. I will try to use hints to understand
the question better.

Hint #34: If a string is a rotation of another, then it's rotation
at a particuler point. For example, a rotation of waterbottle at character
3 means cutting waterbottle at character 3 and putting the right half (erbottle)
before the left half(wat).

* Now I believe for a solution, we can look at the first character of the second word,
when found (e in our example), then we will cut for the character 3 and character 10,
check if one of them equal to word 1, if so return true.





*/

public class InterviewTemplate{

	public static boolean isSubstring(String word1, String word2){
		char startChar = word2.charAt(0);
        String newWord = "";

		for (int i=0; i<word1.length(); i++){
			
			if (word1.charAt(i) == startChar){
				String part1 = word1.substring(0,i);
				String part2 = word1.substring(i);
				
				newWord = part2 + part1;
				
				if (newWord.equals(word2)){
					return true;
				}
			}
		}
		return false;
	}		

	public static void main(String[] args) {
        checkRotation("waterbottle", "erbottlewat");
        checkRotation("abcdef", "defabc");
        checkRotation("hello", "ohell");
        checkRotation("computer", "tercomp");
        checkRotation("algorithm", "ithmalgor");
        checkRotation("openai", "iopena");
        checkRotation("example", "ampleex");
        checkRotation("programming", "mingprogra");
    }

    public static void checkRotation(String word1, String word2) {
        boolean yesOrNo = isSubstring(word1, word2);

        if (yesOrNo) {
            System.out.println("Yes, " + word2 + " is a rotation of " + word1);
        } else {
            System.out.println("No, " + word2 + " is not a rotation of " + word1);
        }
    }

	}