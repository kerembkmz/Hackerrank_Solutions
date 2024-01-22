#include <bits/stdc++.h>
class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        std::unordered_map<int, int> hashMap;
        for (auto& item:nums) {
            if (hashMap.find(item) == hashMap.end()){
                hashMap[item] == 1;
            } else {
                return true;
            }
        }
        return false;
    }
};