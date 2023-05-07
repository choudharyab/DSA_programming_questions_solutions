package BinarySearch;
/*https://leetcode.com/problems/minimize-maximum-of-array/*/
public class MiniMaximumArray {

    static boolean checkMinMaxArray(int mid  , int[] arr){
        long deb = 0;
        for(int i = arr.length-1 ;i>=0;i--){
            if(arr[i] <=mid){
                deb -= Math.min(deb , mid- arr[i]);
            }else{
                deb += (arr[i] - mid);
            }
        }
        return deb <= 0;
    }
    static int minimizeArrayValue(int [] arr){
        int  start = 0 , end = (int) 1e9;
        int mid  , ans = -1 ;
        while(start <= end){
            mid = (int)start + (int)(end - start)/2;
            if(checkMinMaxArray(mid,arr)){
                ans = mid ;
                end = mid -1;
            }else{
                start = mid +1 ;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] arr  = {3,7,1,6};
        int ans = minimizeArrayValue(arr);
        System.out.println(ans);
    }
}
