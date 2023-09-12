class Solution {
    public boolean isValid(String s) {
        Stack<Character> controlStack = new Stack<>();
        
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                controlStack.push(s.charAt(i));
            else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (controlStack.isEmpty()) {
                    return false;
                } 
                if ((s.charAt(i) == ')' && controlStack.pop() != '(') ||
                    (s.charAt(i) == '}' && controlStack.pop() != '{') ||
                    (s.charAt(i) == ']' && controlStack.pop() != '[')) {
                    return false;
                }
            }                        

        }

        return controlStack.isEmpty();
    }
}