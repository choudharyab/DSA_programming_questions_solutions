//https://leetcode.com/problems/subarrays-with-k-different-integers/
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return slidingWindowAtMost(nums,k) - slidingWindowAtMost(nums,k-1);
    }

    public int slidingWindowAtMost(int[] nums , int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int result = 0;
        int distinct = 0;
        int left = 0;

        for(int right = 0 ; right < nums.length;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0) +1);
            if(map.get(nums[right]) == 1) distinct++;

            while(distinct > k){
                int leftNum = nums[left];
                map.put(nums[left],map.get(nums[left]) -1);
                if(map.get(nums[left]) == 0) distinct--;
                left++;
            }

            result += right - left + 1;
        }

        return result;
    }
}
