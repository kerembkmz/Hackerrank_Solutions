#include <bits/stdc++.h>
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> numbers_map;
        for (int i=0; i<nums.size(); i++)
        {
            int c = target - nums[i];
            if (numbers_map.find(c) != numbers_map.end()){
                return vector<int> {numbers_map[c], i};
            }
            numbers_map[nums[i]] = i; 
        }

        return {};
    }
};