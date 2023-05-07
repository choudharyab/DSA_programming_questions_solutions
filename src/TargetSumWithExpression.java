public class TargetSumWithExpression {

     static  int findSumWays(int i ,int value,int[] arr,int target){
        if(i == arr.length && value== target) return 1;
        if( i >= arr.length) return 0;
        int add = 0 , minus = 0;

        add = findSumWays(i+1,value+arr[i],arr,target);
        minus = findSumWays(i+1,value-arr[i],arr,target);

        return  add + minus;
     }

     static int f(int len,int[] arr,int target, int value){

         if(len == 0 && target == value) return 1;
         //if(len >= arr.length) return 0;
         if(target == value) return 1;
         int add = 0 ,minus = 0 ;

         if(len >= 0) add = f(len -1 , arr,target,value+arr[len]);
         if(len >= 0 ) minus = f(len -1 ,arr,target,value-arr[len]);

         return  add +minus;

     }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        int target = 3;
        int n = arr.length -1;
        //int ans = findSumWays(0 , 0 , arr,target);
        int ans = f(n,arr,target,0);
        System.out.println("ans "+ans);
    }
}
