public class Solution {
    public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> compliments = new HashMap<>();

		for(int index = 0; index < nums.length; index++) {
			if(compliments.containsKey(nums[index])) {
				return new int[]{(int)compliments.get(nums[index]), index};
			} else {
				compliments.put(target - nums[index], index);
			}
		}

		throw new IllegalArgumentException("No two sum solution");
    }
}