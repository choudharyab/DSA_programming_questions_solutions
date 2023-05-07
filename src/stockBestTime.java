public class stockBestTime {
    static int maxProfit(int[] prices) {

        int maxProfit = 0 ;
        int miniStock = prices[0];

        for(int i=1;i<prices.length;i++){
            int currProfit = prices[i] - miniStock;
            maxProfit =Math.max(currProfit,maxProfit);
            miniStock = Math.min(miniStock,prices[i]);
        }

        return maxProfit;

    }

    static int maxProfitTwo(int[] prices,int ind,int n ,int buy){
       /* int stock1 = 0 , stock2 = 0;
        if(ind == n) return 0;
        if(buy == 0){
            stock1 = 0 + maxProfitTwo(prices,ind+1 ,n,0);  //no transaction
            stock2 = -prices[ind] + maxProfitTwo(prices,ind+1,n,1);  // buy
        }else{
            stock1 = 0 + maxProfitTwo(prices,ind+1 ,n,1);  //no buy because still not sell
            stock2 = prices[ind] + maxProfitTwo(prices,ind+1,n,0);  // buy zero because you sell

        }

        return Math.max(stock1,stock2);*/
        int[][][] dp = new int[n+1][2][3];
       // dp[n][0][0] = dp[n][1][0] = 0;
        int[] ahead = new int[2];
        int[] curr = new int[2];
        ahead[0] = ahead[1] = 0;
        int profit = 0;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                for(int k=1;k<=2;k++){
                    if(j==0){  // where j is buy
                        dp[i][j][k] = Math.max(0+dp[i+1][0][k],-prices[i] +dp[i+1][1][k]);
                    }

                    if(j==1){
                        dp[i][j][k] = Math.max(0+dp[i+1][1][k],prices[i]+dp[i+1][0][k-1]);
                    }

                    //dp[i][j][k] = profit;
                }


            }
        }
        return dp[0][0][2];
    }
    public static void main(String[] args) {
        int [] arr = {3,3,5,0,0,3,1,4};
        int n = arr.length;
        int ans = maxProfitTwo(arr,0,n,0);
        System.out.println("maxProfit " +ans);
    }
}
