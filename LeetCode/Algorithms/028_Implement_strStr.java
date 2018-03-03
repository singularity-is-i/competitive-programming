class Solution {
    public int strStr(String haystack, String needle) {
        int matchLength = needle.length();
        for(int i = 0; i < haystack.length() - matchLength + 1; i++) {
            if(haystack.substring(i, i+matchLength).equals(needle)) {
                return i;
            }
        }
        
        return -1;
    }
}