package Math;

import java.util.Arrays;

public class ArrayDivisible {
    public static int[] divisibilityArray(String word, int m){
         int n  = word.length();
         int [] result = new int[n];
         long num = 0 ;
         for(int i = 0 ;i < n ;i++){
             long digit = word.charAt(i) - '0';
             num = (num * 10 + digit) % m ;
             result[i] = (num == 0) ? 1 : 0;
         }
         return result;
    }
    public static void main(String[] args) {
        String word = "998244353";
        int m = 3 ;
        int [] arr = divisibilityArray(word,m);
        System.out.println(Arrays.toString(arr));

    }
}
