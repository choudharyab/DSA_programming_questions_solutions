package prefixSum;

import java.util.Arrays;

public class minimumSizeSubArray {

    public static   int minSubArrayLen(int[] arr , int target){
        int minSize = 0 ;
        int n = arr.length ;
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for(int i =1 ;i< n;i++){
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }
        System.out.println(Arrays.toString(prefixSum));
        for (int i =0 ;i<n;i++){
            int sum = target - prefixSum[i];
        }
        return minSize;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        int target = 7;
        int ans = minSubArrayLen(arr,target);
        System.out.println(ans);
    }
}
