package DynamicProgramming;

public class MinimumTicket {
    public static int solve(int [] days , int [] costs , int i , int validity , int n) {
        if (i >= n) return 0;
        if(days[i] <= validity){
            return solve(days,costs,i+1, validity, n);
        } else {
            int choose1 = costs[0] + solve(days,costs,i+1, days[i] + 0,n);
            int choose2 = costs[1] + solve(days,costs,i+1,days[i]+6,n);
            int choose3 = costs[2] + solve(days,costs,i+1,days[i]+29, n);

            return Math.min(choose1 , Math.min(choose2,choose3));
        }
    }

    public static int solveDp(int [] days , int [] costs , int n){
        int size = days[n-1] + 1 ;
        int [] dp = new int [size];

        dp[size -1] = Math.min(costs[0],Math.min(costs[1],costs[2]));

        int ptr = n - 2 ;

        for(int i = size - 2 ;i > 0 ;i--){

            if(ptr >= 0 && days[ptr] ==i){
                int val1 = dp[i+1] + costs[0];
                int val2 = costs[1] + ((i+7 >= size) ? 0 : dp[i+7]);
                int val3 = costs[2] + (((i+29) >= size) ? 0  : dp[i+29]);

                dp[i] = Math.min(val1 , Math.min(val2,val3));
                ptr--;

            }else {
                dp[i] = dp[i-1];
            }

        }
        return dp[1];
    }
    public static void main(String[] args) {
        int [] days = {1,4,6,7,8,20};
        int [] costs = {2,7,15};
        int n = days.length ;
        System.out.println(solveDp(days,costs,n));
    }
}
