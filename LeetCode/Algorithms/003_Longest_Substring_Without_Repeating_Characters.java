public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestLength = 0;
        int newStart = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map.get(s.charAt(i)) >= newStart) {
                    int length = i - newStart;
                    newStart = map.get(s.charAt(i)) + 1;
                    map.remove(s.charAt(i));
                
                    if(length > longestLength) {
                        longestLength = length;
                    }   
                } else {
                    map.remove(s.charAt(i));
                }
            }
            map.put(s.charAt(i), i);
        }
        
        int length = s.length() - newStart;
        
        if(length > longestLength) {
            longestLength = length;
        }
        
        return longestLength;
    }
}