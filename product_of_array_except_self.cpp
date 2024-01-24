#include <bits/stdc++.h>
class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) 
    {
        int size = nums.size();
        vector<int> ret_nums(size, 1);
        int prefix = 1;
        for (int i=0; i<size; i++){
            ret_nums[i] = prefix;
            prefix = prefix * nums[i];
        }

        int postfix = 1;
        for (int i=size-1; i>=0; i--){
            ret_nums[i] = ret_nums[i] * postfix;
            postfix = postfix * nums[i];
        }

        return ret_nums;
    }
};