import java.util.Arrays;

class Solution {
    static
    boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][k+1];
        for(int row[] :dp) Arrays.fill(row,-1);
        int totalSum = 0;
        for(int i=0;i<nums.length;i++){
            totalSum += nums[i];
        }
        int target = totalSum/k;
        if(totalSum % k != 0) return false;
        if(nums.length < k) return false;
        // boolean used = new boolean[nums.length];
        // return findWays(n-1,target,nums,dp);
        return findways(nums,new boolean[nums.length],0,k,0,target);
    }

    static boolean findways(int[] nums,boolean[] used ,int start,int k,int currsum,int target){
        if(k ==1 ) return true;
        if(currsum > target) return false;
        if(currsum == target) return findways(nums,used,0,k-1,0,target);
        for(int i=start;i<nums.length;i++){
            if(!used[i] && currsum+nums[i] <= target) {
                used[i] = true;
                if(findways(nums,used,i+1,k,currsum+nums[i],target)) return true;
                used[i] = false;
            }


        }
        return false;
    }

    public static void main(String[] args) {
        int [] nums = {6,5,9,6,3,5,1,10,4,1,4,3,9,9,3,3};
        int k = 9;
        boolean ans = canPartitionKSubsets(nums,k);
        System.out.println("ans "+ans);
    }
}