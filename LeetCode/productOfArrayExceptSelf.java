/*
Given: int[] nums
Return: int[] answer

where answer[i] == (product of all arrays in nums) / nums[i]

The product of any prefix or suffix will fit a 32-bit integer.

Algorithm must be in O(n) and without using the division operation.

_MIND DUMP_

Since we cannot use the division operation, If we start from the end position,
we can continue finding the solution by multiplication instead of division. 

Spent more than 1 hour, couldn't get the answer right when there are 0's involved. 

So I have looked at the explenation of the problem, and saw the prefix, postfix method. 
I will try to implement it myself.
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        
        int prefixTotal = 1;
        for (int i=0; i<nums.length; i++){
            prefixTotal = prefixTotal * nums[i];
            prefix[i] = prefixTotal;
        }

        int postfixTotal = 1;
        for (int i=nums.length-1; i>=0; i--){
            postfixTotal = postfixTotal * nums[i];
            postfix[i] = postfixTotal;
        }

        for (int i=0; i<nums.length; i++){
            if (i==0){
                answer[i] = postfix[1];
            }
            else if(i==nums.length-1){
                answer[i] =prefix[i-1] ;
            }
            else {
                answer[i] = prefix[i-1] * postfix[i+1];
            }
        }

        return answer;

    }
}

/*
Time Complexity:
O (N + N + N) ≅ O(N) where N is the length of nums.

Space Complexity:
O(N + N + N) ≅ O(N) where N is the length of nums.
*/