/*
We are given an unsorted array of integers. And we are asked to return the longest
consecutive elements sequence. 
 ~ Algorithm Must run in O(n) time.

I tried to solve with hashMap but it was still passing O(N), so looked up the logic for a 
faster solution, and found the set start solution. 

It is so smart and Since it is O(n) + o(n), total time complexity is ≅ O(N).


*/
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int maxLength = 0;
        
        for (int i : nums){
            if (!set.contains(i-1)){
                //Start value
                int length = 0;
                while(set.contains(i+length)){
                    length++;
                    if (length > maxLength)
                        maxLength = length;
                }
            }
        }
        return maxLength;

        
    }
}