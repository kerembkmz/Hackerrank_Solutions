class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        str = str.replaceAll("[^a-zA-Z0-9]", "");
        str = str.replaceAll(" ", "");
        Stack<Character> charList = new Stack<>();

        for (int i=0; i<str.length()/2; i++){
            charList.push(str.charAt(i));
        }
        for (int i=(str.length() + 1)/2 ; i<str.length(); i++){
            if (charList.pop() != str.charAt(i)){
                return false;
            }
        }
        
        

        


        return true;
    }
}