class Solution {
    public boolean isAnagram(String s, String t) {
        char[] arrayS = s.toCharArray();
        char[] arrayT = t.toCharArray();

        Arrays.sort(arrayS);
        Arrays.sort(arrayT);

        String sortedS = String.valueOf(arrayS);
        String sortedT = String.valueOf(arrayT);
        if (sortedS.equals(sortedT))
            return true;
        else
            return false; 
    }

    /*
    Time Complexity:
    We are taking them as O(N) because the time will be based on the
    longer string, since the faster operation is uncalculated to the time 
    complexity, we will be taking the longer string.
    toCharArray: O(N)
    Sorts: O(N logN) 
    Equals: O(N)

    Total Time Complexity: O(N logN) + O(N) + O(N) ≅ O(N logN)
    
    
    Space Complexity:
    char arrays: O(N) where N is the length of the larger size string.
    Strings: O(N) where N is the length of the larger size string.

    Total Space Complexity: O(N+N) ≅ O(N)
    */
}