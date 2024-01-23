class Solution {
public:
    vector<int> runningSum(vector<int>& nums) {
        int size = nums.size();
        vector<int> returnNum(size, 0);
        int prefix = 0;
        for (int i=0; i<size; i++){
            
            prefix += nums[i];
            
            returnNum[i] = prefix;
        }
        return returnNum;

    }
};