class Solution2 {
    public void rotate(int[] nums, int k) {
        int count = 0;
        for(int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            }while(start != current);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, -100, 3, 99};
        Solution2 solution = new Solution2();
        solution.rotate(nums, 2);
    }
}