class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numberStack = new Stack<>();
    
        for (int i=0; i<tokens.length; i++){
            if (tokens[i].equals("+")|| tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/") ){
                int num1 = numberStack.pop();
                int num2 = numberStack.pop();
                if (tokens[i].equals("+")){
                    numberStack.push(num1 + num2);
                }else if(tokens[i].equals("-")){
                    numberStack.push(num2 - num1);
                }else if(tokens[i].equals("*")){
                    numberStack.push(num1 * num2);
                }else if(tokens[i].equals("/")){
                    numberStack.push(num2 / num1);
                }
            }else {
                numberStack.push(Integer.parseInt(tokens[i]));
            }   
        }
        
        return numberStack.pop();
}}