/*
Mind Dump:
Given: Array of integers, and a target number.
Output: 2 Positions that add up to the target number.
Important Information: Only one valid answer exists.

Initial approach was to add all of the doubles, however this 
approach is O(n^2) and it tries a lot of unreasoable approaches.

So I will try to search the complements of the numbers using a 
hashMap to achieve a more efficient solution.

Here is the method.
1- Start iterating through the list.
    1- Calculate the complement using target - nums[i].
    2- If the hashMap contains the complement key,
        1- return {hashMap.get(complement), i}
    3- If the hashMap does not contain the complement key,
        1- add the value of the i and the i itself (hashMap.put(nums[i],i))
2- If there is no valid pair, return empty list with size 2.
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i=0; i<nums.length; i++){
            int complement = target - nums[i];

            if (hashMap.containsKey(complement)){
                return new int[]{hashMap.get(complement), i};
            }
            hashMap.put(nums[i], i);
        }

        return new int[2];
    }
}

/*
Time Complexity:
    Since we are iterating through the array only once, this approach has time complexity O(N)
Space Complexity:
    Since in the wors case scenario, we copy all of the elements of the array to the hashMap only once, 
    the space complexity is also O(N).
*/