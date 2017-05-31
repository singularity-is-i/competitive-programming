public class Solution {
    public int removeDuplicates(int[] nums) {
        int length = 0;
        
        if(nums.length != 0) {
            length++;
        
            for(int i = 1; i < nums.length; i++) {
                if(nums[i] != nums[length-1]) {
                    nums[length++] = nums[i];
                }
            }
        }
        
        return length;
    }
}