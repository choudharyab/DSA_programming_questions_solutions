package Recursion;

import java.util.Arrays;

public class EliminationGame {
    public static void main(String[] args) {
        //int[] arr = {1,2,3,4,5,6,7,8,9};
        int n = 1;
        int ans = lastRemainingRecursion(n);
        System.out.println("ans "+ ans);

    }

    static int findingLastElement(int n){
        boolean left = true ;
        boolean right = false;
        int [] arr = new int[n];
        for(int i =0 ;i<n ;i++){
            arr[i] = i+1;
        }
        System.out.println("arr "+ Arrays.toString(arr));

        return n;
    }

    static int lastRemaining(int n) {
        int start = 1, step = 1, remain = n;
        boolean right = true;
        while (remain > 1) {
            if (right || remain % 2 == 1) start += step;
            remain /= 2;
            step *= 2;
            right = !right;
        }
        return start;
    }

    static int lastRemainingRecursion(int n){
        int ans = 1 ;
        if( n == 1) return ans ;

        ans = 2 * (1+ n/2 - lastRemaining(n/2));
        return ans;
       // return n == 1 ? 1 : 2 * (1 + n/2 -lastRemainingRecursion(n/2));
    }
    /*
    2 + n - 2lastRemaining(n/2);
     n =9
  2 + 9 -8 8 = 2 * lastRemain(4/2)
   4 = 2 * lastRemain(2/2)
     2 * 1
    * */

}


/*  n = 9
    1,2,3,4,5,6,7,8,9
    left = true
    right = false
    2,4,6,8  -- remaining   1,3,5,7,9 -- remove here make left = false and right = true
    2 6 --> remaining  4,8 remove here right = false and left = true
    6 -> no number left hence left false and right = false

* */
