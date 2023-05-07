public class oneAndZeroInstring {
    static  int findingOneAndZero(String[] strs, int m ,int n) {
        int[][] dp = new int[m+1][n+1];
        for(String s : strs) {
            int one = 0 , zero = 0;
            for(char c : s.toCharArray()){
                if(c == '0') zero++;
                else one++;
            }
            for(int i=m ;i>=zero;i--){
                for(int j=n;j>=one;j--){
                    dp[i][j] = Math.max(dp[i][j],dp[i-zero][j-one]+1);
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        String[] strs = {"10","0001","111001","1","0"};
        int m = 5 ,n =3;
        System.out.println(findingOneAndZero(strs,m,n));

    }
}

/*Explanation of above code
*  strs = {"10","0001","111001","1","0"}  m =5 n=3
* iteration code strs[0] = 10
* counting  one =1 and zero =1;
* for(5,>=1) for(3,>=1)  dp[5][3] = math.max(dp[5][3],dp[4][2]+1);
*
*
* */

