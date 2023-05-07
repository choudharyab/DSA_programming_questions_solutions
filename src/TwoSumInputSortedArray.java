import java.util.Arrays;

public class TwoSumInputSortedArray {
    public  static int[] twoSum(int[] arr , int target){
        int left =  0 ;
        int right = arr.length -1;
        int [] twoIndexArr = new int[2];

        while(left < right){
            long sum = arr[left] + arr[right];
            if(sum == target){
                twoIndexArr[0] = left +1;
                twoIndexArr[1] = right +1;
                left++;right--;
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }

        return twoIndexArr;

    }
    public static void main(String[] args) {
        int [] arr = {2,3,4};
        int target = 6 ;
        int [] ans = twoSum(arr,target);
        System.out.println("Ans-------> "+ Arrays.toString(ans));
    }
}
