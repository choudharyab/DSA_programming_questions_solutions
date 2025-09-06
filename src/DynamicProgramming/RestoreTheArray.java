//https://leetcode.com/problems/restore-the-array/submissions/1761102794/
/*Recursion T.c = 0(n * log k) */
class Solution {
    public static int mod = 1000000007;
    public int numberOfArrays(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        return solve(s,k ,0);
    }

    private int solve(String s , int k, int currentIndex){

        if(currentIndex == s.length()) return 1;
        if(s.charAt(currentIndex) == '0') return 0 ;
        long nums = 0 , ways = 0;

        for(int i = currentIndex ; i< s.length() ;i++){
            //convert char to number
            nums = nums * 10 + (s.charAt(i) - '0');
            if(nums > k) break;
            ways = (ways + solve(s,k,i+1)) % mod;
        }
        return (int) ways;

    }
}

/*Memoziation T.c= 0(n*n) s.c =0(n) */ 
class Solution {
    public static int mod = 1000000007;
    public int numberOfArrays(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        Integer [] dp = new Integer[s.length()];
        return solve(s,k ,0,dp);
    }

    private int solve(String s , int k, int currentIndex,Integer [] dp){

        if(currentIndex == s.length()) return 1;
        if(s.charAt(currentIndex) == '0') return 0 ;
        if(dp[currentIndex] != null) return dp[currentIndex];
        long nums = 0 , ways = 0;

        for(int i = currentIndex ; i< s.length() ;i++){
            //convert char to number
            nums = nums * 10 + (s.charAt(i) - '0');
            if(nums > k) break;
            ways = (ways + solve(s,k,i+1,dp)) % mod;
        }
        return dp[currentIndex] = (int) ways;

    }
}

/*Tabulazation */
class Solution {
    public static int mod = 1000000007;
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        int [] dp = new int[n+1];
        dp[n] = 1; //base cases as we reached end of string

        for(int i = n-1 ; i>=0 ;i--){
            if(s.charAt(i) == '0'){
                dp[i] = 0;
                continue;
            }
            long nums = 0;
            for(int j = i ; j< n ;j++){
                nums = nums * 10 + (s.charAt(j) - '0');
                if(nums > k) break;
                dp[i] = (dp[i] + dp[j+1]) % mod;
        

            }
        }

        return dp[0];
    }
}