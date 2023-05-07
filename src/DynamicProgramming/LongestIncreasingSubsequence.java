package DynamicProgramming;

public class LongestIncreasingSubsequence {

    static  int lengthOfLISRec(int currentId , int prevId ,int [] arr , int n ){
        if(currentId == n) return 0 ;

        int notTake = 0 + lengthOfLISRec(currentId+1 , prevId,arr ,n);
        int take = Integer.MAX_VALUE;
        if(prevId == -1 || arr[currentId] > arr[prevId]){
            take = 1 + lengthOfLISRec(currentId+1 , currentId , arr , n);
        }

        return Math.max(notTake , take);

    }

    static int lengthDp(int [] arr , int n) {
        int dp [][] = new int[n+1][n+1];
        for(int idx=n-1 ; idx>=0 ; idx--){
            for(int prev = idx ; prev>=0 ; prev--){
                int not_pick = dp[idx+1][prev];
                int pick = 0;
                if(prev==0 || arr[idx] > arr[prev-1]){
                    pick = 1 + dp[idx+1][idx+1];
                }
                dp[idx][prev] = Math.max(pick , not_pick);
            }
        }
        return dp[0][0];
    }

    static int findingDp(int [] arr , int n){
        int lis[] = new int[n];
        int i, j, max = 0;

        /* Initialize LIS values for all indexes */
        for (i = 0; i < n; i++)
            lis[i] = 1;

        /* Compute optimized LIS values in
           bottom up manner */
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

        /* Pick maximum of all LIS values */
        for (i = 0; i < n; i++)
            if (max < lis[i])
                max = lis[i];

        return max;
    }

   public static void main(String[] args) {
        int [] arr = {0,1,0,3,2,3};
        int n = arr.length;
        int count = lengthOfLISRec(0, -1 ,arr,n);
        System.out.println("increasing count "+count);
    }
}


