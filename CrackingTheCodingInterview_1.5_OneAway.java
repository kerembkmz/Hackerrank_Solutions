import java.util.*;

/*

Cracking the coding interview, Interview Questions 1.5

OneAway: There are three types of edits that can be 
performed on strings: insert a character , remove a
character, or replace a character. Given two strings, 
write a function to check if they are one edit(or zero edits)
away.  

Example
pale, ple -> true
pales, pale -> true
pale, bale -> true
pale, bake -> false

Hints: #23, #97, #130
_________________________________________________________

--Mind Dump--

* The different characters total quantity should be <= 1 if we are
one step away. I will try creating a map for one string, than use
the numbers stored with the related letters to find the different 
characters count. 
 -There were erros in my code because I did not count the replace
 method.

Used Hint #23 -> Checking conditions seperately.

When I though about my problem, I was thinking about total difference
should be <= 1 for all cases, however, if the lengths of the words
are same, using the replace operation, the difference can be 2. Once
I implemented it, it works with no errors. Lastly instead of using hashmaps,
I changed the logic to use charArray because of the positioning of the
letters are also important.





*/

public class InterviewTemplate{	
		public static void main(String[] args) {
			String[][] tests = {{"a", "b", "true"}, 
					{"", "d", "true"},
					{"d", "de", "true"},
					{"pale", "pse", "false"},
					{"acdsfdsfadsf", "acdsgdsfadsf", "true"},
					{"acdsfdsfadsf", "acdsfdfadsf", "true"},
					{"acdsfdsfadsf", "acdsfdsfads", "true"},
					{"acdsfdsfadsf", "cdsfdsfadsf", "true"},
					{"adfdsfadsf", "acdfdsfdsf", "false"},
					{"adfdsfadsf", "bdfdsfadsg", "false"},
					{"adfdsfadsf", "affdsfads", "false"},
					{"pale", "pkle", "true"},
					{"pkle", "pable", "false"}};
			for (int i = 0; i < tests.length; i++) {
				String[] test = tests[i];
				String a = test[0];
				String b = test[1];
				boolean expected = test[2].equals("true");
			
				test(a, b, expected);
				test(b, a, expected);
			}
		}

		public static void test(String a, String b, boolean expected) {
			boolean result = oneEditAway(a, b);
			if (result == expected) {
				System.out.println(a + ", " + b + ": success \n");
			} else {
				System.out.println(a + ", " + b + ": error \n");
			}
		}

		public static boolean oneEditAway(String word1, String word2){
			int diffCharNumber = 0;
			int lengthDiff = Math.abs(word1.length() - word2.length());

			char[] charArray1 = word1.toCharArray();
    		char[] charArray2 = word2.toCharArray();



    		int i = 0;
    		int j = 0;

    		while (i < charArray1.length && j < charArray2.length) {
    		    if (charArray1.length == 1 && charArray.length == 1){
    		        return true;
    		    }
        		if (charArray1[i] != charArray2[j]) {
            		diffCharNumber++;
    			if (lengthDiff == 0) {
        		if (i + 1 < charArray1.length && j + 1 < charArray2.length &&
            		charArray1[i + 1] == charArray2[j + 1]) {
            		i++;
            		j++;
        		} else {
            		return false;
        		}
        		} else if (charArray1.length > charArray2.length) {
        			i++;
    			} else {
        			j++;
    			}
				} else {
    				i++;
    				j++;
				}
    		}

    		System.out.println(diffCharNumber + "\n");

    		
			if (lengthDiff == 0){
				if (diffCharNumber > 2){
					return false;
				}
			}
			else if(lengthDiff == 1){
				if (diffCharNumber > 1){
					return false;
				}
			}
			if (charArray1.length == 1 && charArray2.length == 1){
    			return true;
    		}

			return true;

		}


		// initial solution, has a lot of errors.
		/*
		public static boolean oneEditAway(String word1, String word2){
			int diffCharNumber = 0;
			HashMap<Character, Integer> hashMapW1 = new HashMap<>();

			for (char a:word1.toCharArray()){
				hashMapW1.put(a,hashMapW1.getOrDefault(a,0) + 1);
			}

			for (char b:word2.toCharArray()){
				hashMapW1.put(b,hashMapW1.getOrDefault(b,0) - 1);
			}

			for (char c:hashMapW1.keySet()){
				if (Math.abs(hashMapW1.get(c)) > 0){
					diffCharNumber += 1;
				}
			}

			System.out.println(diffCharNumber);
			if (Math.abs(diffCharNumber) > 1) {
				return false;
			}
			else {
				return true;
			}

		}
		*/

	}