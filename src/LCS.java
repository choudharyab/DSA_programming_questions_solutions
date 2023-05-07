import java.util.Arrays;

public class LCS {
    /*
    * Recursion*/
    static int longestCommonSub(int n1,int n2,String s1 ,String s2){
        if(n1 <= 0 || n2 <= 0) return 0;
        int matchString = 0,notMatchString = 0;
        if(s1.charAt(n1-1) == s2.charAt(n2-1)){
             matchString = 1 + longestCommonSub(n1-1,n2-1,s1,s2);
        }else{
             notMatchString = 0 + Math.max(longestCommonSub(n1-1,n2,s1,s2),longestCommonSub(n1,n2-1,s1,s2));

        }

        return matchString + notMatchString;

    }

   /* Memoziation*/
    static int longestCommonSubMemo(int n1,int n2,String s1 ,String s2,int[][] dp){
        if(n1 <= 0 || n2 <= 0) return 0;

        if(dp[n1-1][n2-1] != -1) return dp[n1-1][n2-1];

        if(s1.charAt(n1-1) == s2.charAt(n2-1)){
            dp[n1][n2] = 1 +longestCommonSubMemo(n1-1,n2-1,s1,s2,dp);
        }else {
            dp[n1][n2] = 0 + Math.max(longestCommonSubMemo(n1-1,n2,s1,s2,dp),longestCommonSubMemo(n1,n2-1,s1,s2,dp));

        }

        return dp[n1][n2];

    }


    static int tabLongest(String s1,String s2){
        int n = s1.length();
        int m = s2.length();

        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++) dp[i][0] = 0;
        for(int j=0;j<=m;j++) dp[0][j] = 0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        int n1 = s1.length();
        int n2 = s2.length();
        //int [][] dp = new int[n1+1][n2+1];
        //for(int row[] : dp) Arrays.fill(row ,-1);

        int ans = tabLongest(s1,s2);
        System.out.println("Ans-----------> "+ans);
    }
}
