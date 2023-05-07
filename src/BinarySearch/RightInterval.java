package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RightInterval {
    static int [] findRightIntervalBruteForce(int [][] arr){
        int [] ans = new int[arr.length];
        for(int i= 0 ;i<arr.length;i++){
            int minvalue =Integer.MAX_VALUE;
            int idx = -1 ;
            for(int j = 0 ;j< arr.length;j++){
                if(arr[j][0] >= arr[i][1] && minvalue > arr[j][0]){
                    idx = j;
                    minvalue = Math.min(minvalue,arr[j][0]);
                }
            }
            ans[i] = idx;
        }
        return ans;
    }

    static int[] findRightInterval(int [][] arr){
        int [] firstArr = new int[arr.length];
        HashMap<Integer ,Integer> map = new HashMap<>();
        for(int i =0 ;i< arr.length ;i++){
            map.put(arr[i][0],i);
            firstArr[i] = arr[i][0];
        }
        Arrays.sort(firstArr);
        int [] ans = new int[arr.length];
        for(int i = 0 ;i< arr.length;i++){
            int key = binarySearch(firstArr ,arr[i][1]);
            if(key == firstArr.length){
                ans[i] = -1;

            }else if(key == 0) {
                if(arr[i][1] <= firstArr[0]){
                    ans[i] = map.get(firstArr[0]);
                }else{
                    ans[i] = -1 ;
                }

            }else {
                ans[i] = map.get(firstArr[key]);
            }
        }

        return ans;


    }

    static int binarySearch(int [] arr ,int target){
        int start = 0 ;
        int end = arr.length -1 ;
        while(start <= end){
            int mid = start + (end- start)/2;
            if(arr[mid] < target){
                start = mid +1 ;
            }else{
                end = mid -1 ;
            }
        }
        return start;

    }
    public static void main(String[] args) {
        int [] [] arr  = {{3,4},{2,3},{1,2}};
        int [] ans = findRightIntervalBruteForce(arr);
        System.out.println(Arrays.toString(ans));
    }
}
