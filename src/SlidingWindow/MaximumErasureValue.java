//https://leetcode.com/problems/maximum-erasure-value/description/
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int i = 0 ;
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        for(int j = 0 ; j < n ;j++){
            while(set.contains(nums[j])){
                sum -= nums[i];
                set.remove(nums[i]);
                i++;

            }
            set.add(nums[j]);
            sum += nums[j];
            maxSum= Math.max(maxSum,sum);
                
        }

        return maxSum;
        
    }
}