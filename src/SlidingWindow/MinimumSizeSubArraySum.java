//https://leetcode.com/problems/minimum-size-subarray-sum/?envType=problem-list-v2&envId=sliding-window

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0 , sum = 0;
        int result = Integer.MAX_VALUE;
        int n = nums.length;

        for(right = 0 ; right < n ;right++){
            sum += nums[right];
            while(sum >= target){
                result = Math.min(result, right - left +1);
                sum -= nums[left];
                left++;
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
        
    }
}