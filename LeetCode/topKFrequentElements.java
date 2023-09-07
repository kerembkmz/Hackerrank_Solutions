/*
MIND DUMP
~ I have solved a similar question to this before.
1. I will create a hashMap in the format <num, frequency>
2. I will convert the hashMap to a list to sort them by value.
3. Sort the list by value in descending order.
4. Go entry by entry until we get to k numbers in the new, sorted list 
and add them to the returnList.

*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> frequencyList = new ArrayList<>(frequencyMap.entrySet());
        Collections.sort(frequencyList, (a, b) -> b.getValue().compareTo(a.getValue()));    
        

        int[] returnList = new int[k];
        int i = 0;
        
        for (Map.Entry<Integer, Integer> item : frequencyList) {
            if (i == k) {
                break;
            }
            returnList[i++] = item.getKey();
        }

        return returnList;


    }
}

/*
Time Complexity:
N: Number of elements in nums
N: Number of elements copying into List
N * logN: Sorting the list
k: number k

Time Complexity is N + N * LogN + k ≅ O(N + NLogN + k)

Space Complexity:
Since we are copying all the elements in nums twice, and adding k elements into 
return list,
space complexity is   N + N + k ≅ O(N + k)

*/