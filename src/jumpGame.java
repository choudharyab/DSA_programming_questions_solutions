public class jumpGame {

    static int findMinJump(int[] arr){
        int n = arr.length ;
        int jump = 0 ;
        int reachableIndex = 0 , startingIndex = 0 ;

        for(int i = 0 ;i< n-1 ;i++){
            reachableIndex = Math.max(reachableIndex , i + arr[i]);

            if( i == startingIndex){
                jump++;
                startingIndex = reachableIndex;
            }
        }

        return jump;
    }

    public static  boolean canReach(int[] arr, int st) {
        if(st >= 0 && st < arr.length && arr[st] < arr.length){
            int jump = arr[st];
            arr[st] += arr.length;
            if(jump == 0 ) return true;
            boolean leftJump = canReach(arr , st - jump);
            boolean rightJump = canReach(arr , st + jump);

            if(leftJump || rightJump) return true;

        }
        return false ;
    }


        public static void main(String[] args) {
        int [] arr = {2,3,1,1,4};
        int [] arr1 = {4,2,3,0,3,1,2};
        int startIndex = 5 ;
        boolean reachable = canReach(arr1 , startIndex);
        int ans  = findMinJump(arr);
        System.out.println("finding jump " +ans);
            System.out.println("Reachable  " +reachable);

        }
}
/*
 0 1 2 3 4 5 6
[4,2,3,0,3,1,2]  start = 5   n = 7
when you are at index  i   you can either i - arr[i]   //left or i + arr[i]  //right
case Index = 5
left = 5 - 1 = 4 re  right = 5 + 1 = 6
case Index = 4
left = 4 -3 = 1 re  right = 4+3 = 7
case Index  1
left  = 1-2        right = 1+2 = 3 re
case index 3
left = 3 - 0 = 3    right = 3+3 = 6

5->4->1->3
5->6->4->1->3
* **/

/***     0 1 2 3 4 5
 * s = " 0 1 1 0 1 0", minJump = 2, maxJump = 3
 * i + minJump <= j <= min(i + maxJump, s.length - 1) and s[j] == 0
 *
 * i = 0
 * **/

