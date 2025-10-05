//https://leetcode.com/problems/minimum-removals-to-balance-array/description/?envType=problem-list-v2&envId=sliding-window
class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0 ;
        int maxBalanced = 0 ;

        for(int right = 0 ; right < n;right++){
            if(nums[right] > (long) k * nums[left]){
                left++;
            }
            maxBalanced = Math.max(maxBalanced,right - left +1);
        }

        return n - maxBalanced;
    }
}

/*
| right | nums[right] | Condition `nums[right] <= k*nums[left]` | Action                      | Window | maxWindow |
| ----- | ----------- | --------------------------------------- | --------------------------- | ------ | --------- |
| 0     | 1           | ✅ 1 ≤ 3                                 | expand                      | [1]    | 1         |
| 1     | 3           | ✅ 3 ≤ 3                                 | expand                      | [1,3]  | 2         |
| 2     | 9           | ❌ 9 > 3*1                               | shrink `left→1` → ✅ 9 ≤ 3*3 | [3,9]  | 2         |
| 3     | 12          | ❌ 12 > 3*3                              | shrink `left→2`             | [9,12] | 2         |

 */