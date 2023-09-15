class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> returnList = new ArrayList<>();

        Arrays.sort(nums);

        
        
    
        for (int i=0; i<nums.length-1; i++){
            if (i==0 ||i>0 && nums[i] != nums[i-1]){
                int start = i+1;
                int end = nums.length - 1;

                int target = 0 - nums[i];

    
    
    

                while (start<end){
                    if (nums[start] + nums[end] == target){
                        List<Integer> process = new ArrayList<>();
                        process.add(nums[i]);
                        process.add(nums[start]);
                        process.add(nums[end]);
                        returnList.add(process);

                        while(start< end  && nums[start] == nums[start+1]){
                            start++;
                        }
                        while(start<end && nums[end] == nums[end-1]){
                            end--;
                        }

                        start++;
                        end--;

                    }
                    else if(nums[start] + nums[end] > target){
                        end--;
                    }
                    else {
                        start++;
                    }
                }
            }
        }   
       

        return returnList;
    }
}