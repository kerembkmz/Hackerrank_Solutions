#include <bits/stdc++.h>
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> map;
        for (auto& item : strs) {
            string sortedItem = item;
            sort(sortedItem.begin(), sortedItem.end());
            if (map.find(sortedItem) == map.end()) {
                map[sortedItem] = vector<string>{item};
            } else {
                map[sortedItem].push_back(item);
            }
        }

        vector<vector<string>> returnString;
        for (auto& pair : map) {
            returnString.push_back(pair.second);
        }

        return returnString;
    }
};