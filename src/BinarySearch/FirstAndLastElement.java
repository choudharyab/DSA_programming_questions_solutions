package BinarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FirstAndLastElement {

    public static int[] searchRange(int[] nums , int target){
        int[] ans = {-1,-1};

        int start = search(nums,target,true);
        int end = search(nums, target, false);

        ans[0] = start ;
        ans[1] = end;



        return ans;

    }

    static int search(int[] nums , int target , boolean findStartIndex){

        int start = 0 ;
        int end = nums.length -1 ;
        int ans = -1 ;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] > target){
                end = mid -1;
            }else if(target > nums[mid]){
                start = mid +1 ;
            }else{
                ans = mid;
                if(findStartIndex){
                    end = mid -1;

                }else{
                    start = mid +1 ;
                }
            }
        }

        return ans;

    }
    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};
        int target = 8 ;
        int[] ans = searchRange(nums,target);
        System.out.println(Arrays.toString(ans));
    }
}
