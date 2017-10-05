class Solution {
    public int maxSubArray(int[] nums) {
        int maxValue = nums[0];
        int currentMax = 0;
        
        for(int i = 0; i < nums.length; i++) {
            currentMax+= nums[i];
            
            if(maxValue < currentMax) {
                maxValue = currentMax;
            }
            
            if(currentMax < 0) {
                currentMax = 0;
            }
        }
        
        return maxValue;
    }
}