package BinarySearch;

import java.util.Arrays;

/**/
public class DuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int start = 0 ;
        int end = nums.length ;
      //  Arrays.sort(nums);
        while (start < end){
            int count = 0;
            int mid = start + (end - start)/2;
            for(int n : nums){
                if( n <= mid){
                    count++;
                }
            }

            if(count <= mid){
                start = mid +1;
            }else {
                end = mid ;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int [] arr  = {1,3,4,2,2} ;
        int ans = findDuplicate(arr);
        System.out.println(ans);
    }
}
