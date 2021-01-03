class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for(int fast = 1; fast < nums.length; ) {
            if (nums[slow] == nums[fast]) {
                fast++;
            } else {
                slow ++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;
    }
}