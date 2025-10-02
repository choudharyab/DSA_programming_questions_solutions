//https://leetcode.com/problems/contains-duplicate-iii/submissions/1788905955/?envType=problem-list-v2&envId=sliding-window

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int n = nums.length ;
        if(indexDiff <= 0 || valueDiff < 0) return false;
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0 ; i< n ;i++){
            Long num = (long) nums[i];
            
            // Find the smallest >= num
            Long ceil = set.ceiling(num);
            if(ceil != null && (ceil - num <= valueDiff )) return true;

            // Find the largest <= num
            Long floor = set.floor(num);
            if(floor != null && (num - floor <= valueDiff )) return true;

            set.add(num);

            // Maintain window size (remove nums[i - indexDiff])
            if( i >= indexDiff){
                set.remove((long) nums[i - indexDiff]);
            }

        }

        return false;
    }
}