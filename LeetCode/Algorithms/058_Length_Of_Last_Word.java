public class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        
        while(s.length() > 0 && s.charAt(s.length()-1) == ' ') {
            s = s.substring(0, s.length()-1);
        }
        
        if(s.length() > 0) {
            for(int i = s.length() - 1; i >= 0; i--) {
                if(s.charAt(i) == ' ') {
                    break;
                } else {
                    length++;
                }
            }
        }
        
        return length;
    }
}