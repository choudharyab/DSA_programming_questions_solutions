//https://leetcode.com/problems/2-keys-keyboard/submissions/1762283760/
/*Recursion */
class Solution {
    public int minSteps(int n) {
        if( n == 1) return 0;
        return 1 + solve(n,1,1);
    }

    private int solve(int n , int currentA , int clipA){
        if(currentA == n) return 0;

        if(currentA > n) return Integer.MAX_VALUE / 2; // to avoid overflow

        int copyAndPaste = 2 + solve(n , currentA + currentA ,currentA);
        int paste = 1 + solve(n,currentA + clipA,clipA);

        return Math.min(copyAndPaste,paste);
    }
}

/*Memoziation */
class Solution {
    public int minSteps(int n) {
        int [][] dp = new int[n+1][n+1];
        for(int [] row : dp){
            Arrays.fill(row , -1);
        }
        if( n == 1) return 0;
        return 1 + solve(n,1,1,dp);
    }

    private int solve(int n , int currentA , int clipA,int [][] dp){
        if(currentA == n) return 0;

        if(currentA > n) return Integer.MAX_VALUE / 2;

        if(dp[currentA][clipA] != -1) return dp[currentA][clipA];

        int copyAndPaste = 2 + solve(n , currentA + currentA ,currentA,dp);
        int paste = 1 + solve(n,currentA + clipA,clipA,dp);

        return dp[currentA][clipA] = Math.min(copyAndPaste,paste);
    }
}

/*Tabulazation */
class Solution {
    public int minSteps(int n) {
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2 ; i<= n ;i++){
            dp[i] = i ;
            for(int j = i/2 ; j>= 1 ;j--){
                if( i % j == 0){
                    dp[i] = Math.min(dp[i],dp[j] + i/j);
                    break;
                }
            }
        }

        return dp[n];
    }

}