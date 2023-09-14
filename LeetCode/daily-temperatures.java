class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] returnList = new int[temperatures.length];

        for (int i=0; i<temperatures.length; i++){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int dayIndex = stack.pop();
                returnList[dayIndex] = i - dayIndex;
            }

            stack.push(i);
        }

        return returnList;
    }
}