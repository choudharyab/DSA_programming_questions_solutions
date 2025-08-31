//https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/description/
//recursion T.c - > (O(2^(2n))
class SolutionWithRecursion {
    private static final int mod = 1000000007;
    public int countOrders(int n) {
        return (int) solve(n,n,dp);
    }
    private long solve(int pickupLeft , int deliveryLeft){
        if(pickupLeft == 0 && deliveryLeft == 0) return 1 ;
        long count = 0 ;
        if(pickupLeft > 0){
            count = (count + pickupLeft * solve(pickupLeft - 1 , deliveryLeft)) % mod;
        }
        if(deliveryLeft > pickupLeft){
            int availableDeliveries = deliveryLeft - pickupLeft;
            count = (count + availableDeliveries  * solve(pickupLeft , deliveryLeft - 1)) % mod;
        }

        return count;
    }
}

//memoziation T.c - > (O(n))
class SolutionWithTopDown {
    private static final int mod = 1000000007;
    public int countOrders(int n) {
        long [][] dp = new long[n+1][n+1];
        for(long [] row : dp){
            Arrays.fill(row , -1);
        }
        return (int) solve(n,n,dp);
    }
    //memoziation i.e top-down approach
    private long solve(int pickupLeft , int deliveryLeft , long [][] dp){
        if(pickupLeft == 0 && deliveryLeft == 0) return 1 ;
        if(dp[pickupLeft][deliveryLeft] != -1) return dp[pickupLeft][deliveryLeft];
        long count = 0 ;
        if(pickupLeft > 0){
            count = (count + pickupLeft * solve(pickupLeft - 1 , deliveryLeft,dp)) % mod;
        }
        if(deliveryLeft > pickupLeft){
            int availableDeliveries = deliveryLeft - pickupLeft;
            count = (count + availableDeliveries  * solve(pickupLeft , deliveryLeft - 1,dp)) % mod;
        }

        return dp[pickupLeft][deliveryLeft] = count;
    }
}

//Tabulazation i.e bottom-up approach
class SolutionWithBottomUp {
    private static final int mod = 1000000007;
    public int countOrders(int n) {
        long [][] dp = new long[n+1][n+1];
        dp[0][0] = 1 ;
        for(int i = 0 ; i<= n ;i++){
            for(int j = 0 ; j<=n ;j++){
                long count = 0 ;
                if( i == 0 && j == 0) continue; 
                if(i > 0){
                    count += i * dp[i-1][j];
                }
                if(j > i){
                    count += (j-i) * dp[i][j-1];
                }
                dp[i][j] = (count) % mod;
            }
        }
        return (int) dp[n][n];
    }
}