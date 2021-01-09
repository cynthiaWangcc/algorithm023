class Solution {
    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = hashMap.get(target - nums[i]);
            }

            hashMap.put(nums[i], i);
        }

        return result;
    }
}