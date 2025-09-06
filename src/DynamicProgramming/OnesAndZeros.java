//https://leetcode.com/problems/ones-and-zeroes/
/*Recursion */
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        return solve(strs,m,n,0);
    }

    private int solve(String[] strs , int m , int n , int idx){
        if(idx == strs.length) return 0; //no string left

        //count zero and ones in current idx of string
        int [] counts = countsZerosAndOnes(strs[idx]);
        int zeros = counts[0] , ones = counts[1];

        //skip the string
        int not_take = solve(strs,m,n,idx+1);
        int take = 0;
        if( m >= zeros && n >= ones){
            take = 1 + solve(strs, m- zeros, n-ones, idx +1);
        }

        return Math.max(not_take,take);

    }

    private int [] countsZerosAndOnes(String str){
        int [] count = new int[2];
        for(char c : str.toCharArray()){
            if(c == '0') {
                count[0]++;
            }else{
                count[1]++;
            }
        }
        return count;
    }
}

/*Memoziation */
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][m+1][n+1];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve(strs,m,n,0,dp);
    }

    private int solve(String[] strs , int m , int n , int idx,int[][][] dp){
        if(idx == strs.length) return 0; //no string left

        if(dp[idx][m][n] != -1) return dp[idx][m][n];

        //count zero and ones in current idx of string
        int [] counts = countsZerosAndOnes(strs[idx]);
        int zeros = counts[0] , ones = counts[1];

        //skip the string
        int not_take = solve(strs,m,n,idx+1,dp);
        int take = 0;
        if( m >= zeros && n >= ones){
            take = 1 + solve(strs, m- zeros, n-ones, idx +1,dp);
        }

        return dp[idx][m][n] =Math.max(not_take,take);

    }

    private int [] countsZerosAndOnes(String str){
        int [] count = new int[2];
        for(char c : str.toCharArray()){
            if(c == '0') {
                count[0]++;
            }else{
                count[1]++;
            }
        }
        return count;
    }
}

/*Tabulazation */
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int [][] dp = new int[m+1][n+1];
        for(String s : strs){
            int [] counts = countsZerosAndOnes(s);
            int zeros = counts[0] , ones = counts[1];

            for(int i = m ;i>= zeros;i--){
                for(int j= n ;j>= ones;j--){

                    dp[i][j] = Math.max(dp[i][j] ,1+dp[i-zeros][j-ones]);

                }
            }
        }
        return dp[m][n];
 
        
    }

    private int [] countsZerosAndOnes(String str){
        int [] count = new int[2];
        for(char c : str.toCharArray()){
            if(c == '0') {
                count[0]++;
            }else{
                count[1]++;
            }
        }
        return count;
    }
}