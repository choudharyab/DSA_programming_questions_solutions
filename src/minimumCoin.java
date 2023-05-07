public class minimumCoin {
    static long coinChange(int[] coins, int amount) {
        int n = coins.length;
        long[][] dp = new long[n][amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0)
                dp[0][i] = 1;
        }


        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){

                long not_taken = dp[i-1][j];
                //int taken = (int)Math.pow(10,9);
                long taken = 0 ;
                if(coins[i] <= j){
                    taken = dp[i][j-coins[i]];
                }
                dp[i][j] = not_taken + taken;

            }
        }
        return  dp[n-1][amount];
       // if(ans >= (int)Math.pow(10,9)) return -1;
       // return ans;

    }
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 5;

        long ans = coinChange(coins,amount);
        System.out.println("Ans is " + ans);

    }
}
