package Math;

import java.util.Arrays;

public class LeftAndRightDifference {
    public static int[] leftRightDifference(int[] nums) {

        int n = 0;
        int l = nums.length;
        int[] ans = new int[l];

        for (int i = 0; i < l; i++) {
            ans[i] = n;
            n += nums[i];
        }

        n = 0;

        for (int i = l-1; i >= 0; i--) {
            ans[i] = Math.abs(ans[i] - n);
            n += nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int [] arr = {10,4,8,3};
        int [] ans = leftRightDifference(arr);
        System.out.println(Arrays.toString(ans));
    }
}
/*  0    1  2  3
   [10 , 4 ,8,3]
i = 0   left = 0;
i = 1    left = 10  nums[i-1];
i = 2    left = 14  nums[i-1] +
i = 3     left = 22
* */