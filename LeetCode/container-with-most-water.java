/*
Total Time 09:07.

Second try passed all tests.
*/

class Solution {
    public int maxArea(int[] height) {
        int minVertical = 0;
        int maxVertical = height.length - 1; //n is the number of vertical lines.
        
        int maxArea = 0;

        while (minVertical < maxVertical){
            int currentArea = (maxVertical - minVertical) * (Math.min(height[minVertical],height[maxVertical]));

            if (currentArea > maxArea){
                maxArea = currentArea;
            }

            if (height[minVertical] > height[maxVertical]){
                maxVertical--;
            }else{
                minVertical++;
            }
        }

        return maxArea;        
        
    }
}