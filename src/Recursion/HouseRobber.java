package Recursion;

public class HouseRobber {
    public  static  int rob(int [] nums){

        int n = nums.length;
        if (n == 0) return 0;
        if(n ==1 ) return nums[0];
        int twoJumpRobber = circularRob(0,n-2,nums);
        int oneJumpRobber = circularRob(1,n-1,nums);
        return Math.max(twoJumpRobber,oneJumpRobber);
        //return circularRobrec(nums, nums.length-1);
    }

    public static int circularRob(int start , int end , int []  nums){
        int includehouse  = 0, excludehouse = 0 ;
        int temp = 0 ;
        for(int i= start ;i <=end ;i++){
            temp = Math.max(includehouse,excludehouse);
            includehouse = excludehouse + nums[i];
            excludehouse = temp;

        }
        return Math.max(includehouse,excludehouse);
    }

    public  static  int robRec(int [] nums , int n){
        if( n < 0) return 0 ;
        if( n == 0) return nums[0];


        int take = nums[n] + robRec(nums , n -2);
        int notTake =  0 + robRec(nums , n-1);

        return Math.max(take,notTake);
    }

    public  static int robRecDp(int [] nums , int n){
        if( n == 0) return 0;
        if(n == 1 ) return nums[0];
        if(n == 2 ) return Math.max(nums[0],nums[1]);
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i=2 ; i< nums.length;i++){
            dp[i] = Math.max(nums[i]+ dp[i-2],dp[i-1]);
        }

        return dp[n-1];

    }

    public static int circularRobrec(int [] nums , int n){
        if( n <= 0) return 0 ;
        if(n == 1 ) return nums[0];
        if(n == 2 ) return Math.max(nums[0],nums[1]);

        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i =2 ;i< n ;i++){
           // if(i != nums.length-1){
                dp[i] = Math.max(nums[i]+ dp[i-2],dp[i-1]);
            //}
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3};
        int ans = rob(arr);
        System.out.println(ans);
    }
}
/*               1     2    3
* Exclude    0   0     1    2
* Include    0   1     2    3
*
* */