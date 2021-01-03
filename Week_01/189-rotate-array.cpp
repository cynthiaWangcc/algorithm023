#include <vector>

using namespace std;

class Solution {
public: 
    void rotate(vector<int>& nums, int k) {
        reverse(nums, 0, nums.size());
        reverse(nums, 0, k);
        reverse(nums, k, nums.size());
    }

    int main(int argc, char const *argv[])
    {
        vector<int> nums(7);
        for (size_t i = 0; i < 8; i++)
        {
            nums[i] = i;
        }

        rotate(nums, 3);
        return 0;
    }
    

private:
    void reverse(vector<int>& nums, int start, int end) {
        for (size_t i = start; i < (end - start) / 2; i++)
        {
            int temp = nums[start + i];
            nums[start + i] = nums[end - i - 1];
            nums[end - i - 1] = temp;
        }
        
    }
};