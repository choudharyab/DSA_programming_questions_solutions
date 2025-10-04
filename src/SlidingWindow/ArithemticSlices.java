//https://leetcode.com/problems/arithmetic-slices/description/
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        int result = 0;
        int i = 0; // start of current arithmetic window

        for (int j = 2; j < n; j++) {
            // Check if current 3 elements form arithmetic sequence
            if (nums[j] - nums[j-1] == nums[j-1] - nums[j-2]) {
                // number of new arithmetic slices ending at j
                result += (j - i - 1);
            } else {
                // reset window start to previous element
                i = j - 1;
            }
        }

        return result;
    }
}
