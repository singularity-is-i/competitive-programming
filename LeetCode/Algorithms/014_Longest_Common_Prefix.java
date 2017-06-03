public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length > 0) {
            String prefix = strs[0];
            
            for(int i = 1; i < strs.length; i++) {
                int shortestLength;
                
                if(prefix.length() > strs[i].length()) {
                    shortestLength = strs[i].length();
                } else {
                    shortestLength = prefix.length();
                }
                
                prefix = prefix.substring(0, shortestLength);
                
                for(int j = 0; j < shortestLength; j++) {
                    if(prefix.charAt(j) != strs[i].charAt(j)) {
                        prefix = prefix.substring(0, j);
                        break;
                    }
                }
            }
            
            return prefix;
        } else {
            return "";
        }
    }
}