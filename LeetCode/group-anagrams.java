/*
MIND DUMP:
 ~ We can return the answer in any order.
  1. I will sort the indivual words first.
  2. I will use a hashMap to store and group 
  the sorted strings more efficiently.
  3. The Values of the hashMap will be the groued 
  strings, which I will be returning in the end.
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> groupedStrings = new HashMap<>();
        
        for (String word : strs){
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedString = String.valueOf(charArray);

            if (groupedStrings.containsKey(sortedString)) 
                groupedStrings.get(sortedString).add(word);
            else {
                List<String> list = new ArrayList<>();
                list.add(word);
                groupedStrings.put(sortedString, list);
            }
            
        }

        return new ArrayList<>(groupedStrings.values());
    }
}

/*
TIME COMPLEXITY:
 Time complexity is O(n * s logs)
 where 
 n: number of strings in the strs
 s logs : the time it takes to sort the string of length s

SPACE COMPLEXITY:

 Space Complexity is O(n * s)

 because in the worst case scenario, we will store n strings of length s.
*/