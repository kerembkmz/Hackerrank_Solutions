#include <bits/stdc++.h>
class Solution {
public:
    bool isAnagram(string s, string t) {
        unordered_map<char, int> freq_map_of_s;

        if (s.length() != t.length())
        {
            return false;
        }

        for (auto& item : s){
            if (freq_map_of_s.find(item) == freq_map_of_s.end()){
                freq_map_of_s[item] = 1;
            } else {
                freq_map_of_s[item] += 1;
            }
        }

        for (auto& item : t){
            if (freq_map_of_s.find(item) == freq_map_of_s.end() || freq_map_of_s[item] == 0){
                return false;
            } 
            else
            {
                freq_map_of_s[item] -= 1;
            }
        }

        for (auto& pair : freq_map_of_s) {
            if (pair.second != 0) {
                return false;
            }
        }

        return true;


    }
};