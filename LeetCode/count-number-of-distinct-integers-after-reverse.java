class Solution {
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num:nums){
            set.add(num);

            int reversed = 0;
            
            while(num != 0) {
                int digit = num % 10;
                reversed = reversed * 10 + digit;
                num /= 10;
            }

            set.add(reversed);
        }

        
        return set.size();
    }
}