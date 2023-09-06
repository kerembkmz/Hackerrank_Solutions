/*
Mind Dump: 

Given: Integer Aray 
Output: Return true if any value appears twice.

Constraints: 1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

We can convert the number array to a set. Then check if the set and the arrays size, if they 
are the same, then we can return false, if they are not the same, it means there is one or more
duplicates.
*/

class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numbersSet = new HashSet<>();
        for (int i : nums)
            numbersSet.add(i);
        if (numbersSet.size() == nums.length)
            return false;
        return true;
    }
}

/*
Algorithm: 
The add, size and length methods are O(1).
Since we are iterating through the array once, it takes O(N).

So the algorithm has O(N) time complexity.

For Space Complexity, since the worst case scenario is no duplicates, 
the numbersSet will have n elements, so the space complexity will be
O(N) where n is the number of elements in numbersSet.
*/



