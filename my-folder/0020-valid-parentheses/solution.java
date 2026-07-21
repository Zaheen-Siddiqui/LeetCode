class Solution {
    public boolean isValid(String s) {
        if(s.length() == 1)
         return false;

        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i <= s.length() - 1; i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else{
                if (stack.isEmpty()) {
                    return false;
                }
                if((stack.peek() == '(' && s.charAt(i) == ')') || (stack.peek() == '[' && s.charAt(i) == ']') || (stack.peek() == '{' && s.charAt(i) == '}')){
                    stack.pop();
                    continue;
                }
                return false;                
            }
        }
        return stack.isEmpty();
    }
}
