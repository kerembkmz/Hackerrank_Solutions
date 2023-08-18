import java.util.*;

/*

Cracking the coding interview, Interview Questions 1.6

String Compression: Implement a method to perform basic 
 string compression using the counts of repeated characters. 
 For example, the string aabcccccaaa would become a2b1c5a3.
 If the "compressed" string would not become smaller than 
 the original string, your method should return the original 
 string. You can assume the string has only uppercase and 
 lowercase letters (a-z).


Hints: #92, #110
_________________________________________________________

--Mind Dump--

* I will first convert the string to a charArray. Afterwards, 
starting from the first element of the array (index 0), every
element is not traversed, I will increase the counter of the 
letter if it is the same as the previous letter, and restart
the counter and change the previous letter if the letter is not 
same as before.

 -- My first though worked. Did not used any of the hints. 

Will use Hint #110 to make the algorithm more efficient.
Hint #110 : Be careful that you aren't repeatedly concatenating 
strings together. This can be very inefficient.

 * I was concatenating strings together, so I will use stringBuilder
 for the second method.


*/

public class InterviewTemplate{	
		public static void main(String[] args) {
			String compressableString = "aaaaabbbbaaaabbddc";
			String nonCompreesableString = "abcdefg";
			String compressableStringWith2CharsEnding = "aaaaabbbbaaaabbddcc";

			String testString1 = compress(compressableString);
			String testString2 = compress(nonCompreesableString);
			String testString3 = compress(compressableStringWith2CharsEnding);

			String testString4 = efficientCompress(compressableString);
			String testString5 = efficientCompress(nonCompreesableString);
			String testString6 = efficientCompress(compressableStringWith2CharsEnding);

			System.out.println(testString1 + "\n");
			System.out.println(testString2 + "\n");
			System.out.println(testString3 + "\n");
			System.out.println(testString4 + "\n");
			System.out.println(testString5 + "\n");
			System.out.println(testString6 + "\n");
		}

		public static String efficientCompress(String word){
			char[] wordArray = word.toCharArray();
			
			char previousLetter = wordArray[0];
									
			int counter = 1;

			StringBuilder middleStepString = new StringBuilder();

			

			for (int i=1; i<wordArray.length; i++){
				

				if (wordArray[i] == previousLetter){
					counter += 1;
				}
				else if(wordArray[i] != previousLetter){
					middleStepString.append(wordArray[i-1]).append(counter);
					counter = 1;
					previousLetter = wordArray[i];
				}

				if (wordArray[i] == wordArray[wordArray.length - 1]){
					middleStepString.append(wordArray[i]).append(counter);
				}

				
			}

			String returnString = middleStepString.toString();

			return returnString;
		}

		public static String compress(String word){
			char[] wordArray = word.toCharArray();
			
			char previousLetter = wordArray[0];
									
			int counter = 1;

			String returnString = "";

			

			for (int i=1; i<wordArray.length; i++){
				

				if (wordArray[i] == previousLetter){
					counter += 1;
				}
				else if(wordArray[i] != previousLetter){
					returnString = returnString + wordArray[i - 1] + counter;
					counter = 1;
					previousLetter = wordArray[i];
				}

				if (wordArray[i] == wordArray[wordArray.length - 1]){
					returnString = returnString + wordArray[i] + counter;
				}

				
			}

			return returnString;

		}

	}