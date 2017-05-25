public class Solution {
    public boolean isValid(String s) {
        Stack<Character> values = new Stack();
        
        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            switch (current) {
                case '{':   values.push('}');
                            break;
                case '(':   values.push(')');
                            break;
                case '[':   values.push(']');
                            break;
                default:    if(!values.empty()) {
                                if(values.pop() != current) {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                            break;
            }
        }
        
        return values.empty();
    }
}