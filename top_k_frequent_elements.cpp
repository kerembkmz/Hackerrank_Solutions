#include <bits/stdc++.h>
class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> freqMap;
        for (auto& item : nums) {
            if (freqMap.find(item) == freqMap.end()) {
                freqMap[item] = 1;
            } else {
                freqMap[item] += 1;
            }
        }

        auto comparator = [](const pair<int, int>& a,
                             const pair<int, int>& b) {
            return a.second > b.second; 
        };

        priority_queue<pair<int, int>,
                            vector<pair<int, int>>,
                            decltype(comparator)>
            pq(comparator);

        
        for (const auto& pair : freqMap) {
            pq.push(pair);
            if (pq.size() > k) {
                pq.pop(); 
            }
        }

        vector<int> returnVector;
        while (!pq.empty()) {
            returnVector.push_back(pq.top().first);
            pq.pop();
        }

        return returnVector;
    }
};