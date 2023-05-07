import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums ={-1,2,1,-4};
        int target = 1;
        int ans = findingThreeSumClosest(nums,target);
        System.out.println("Ans---> " +ans);
    }

    public  static  int findingThreeSumClosest(int[] nums , int target){
        Arrays.sort(nums);
        long closestSum = Integer.MAX_VALUE;

        for(int i=0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length -1 ;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                int sumClosest = Math.abs(target - sum);
                int nearClosest = Math.abs(target - (int )closestSum);
                if(sumClosest < nearClosest){
                    closestSum = sum;
                }

                if(sum > target) {
                    right--;
                }else{
                    left++;
                }

            }
        }
        return (int) closestSum;

    }
}
