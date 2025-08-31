//https://leetcode.com/problems/student-attendance-record-ii/
class SolutionWithRecursion {
    public static int mod = 1000000007;
    public int checkRecord(int n){
        return (int) solve(0,0,0,n);
    }

    private long solve(int day , int absent , int late , int n){
        if(day == n) return 1;
        if(absent >  1 || late > 2) return 0;
        long totals = 0 ;

        //choice Add 'P'
        totals += solve(day +1 , absent,late,n);
        //choice Add 'A'
        totals += solve(day +1 , absent +1,late,n);
        //choice Add 'L'
        totals += solve(day +1 , absent,late + 1,n);

        return totals % mod;
    }
}

//memoziation top - down approach
class SolutionWithTopDown {
    public static int mod = 1000000007;
    public int checkRecord(int n){
        long[][][] dp = new long[n+1][2][3];
        for(long [][] row : dp){
            for(long [] r : row){
                Arrays.fill(r ,-1);
            }
        }
        return (int) solve(0,0,0,n,dp);
    }

    private long solve(int day , int absent , int late , int n,long[][][] dp){
        if(absent >  1 || late > 2) return 0;
        if(day == n) return 1;
        if(dp[day][absent][late] != -1) return dp[day][absent][late];
        long totals = 0 ;

        //choice Add 'P'
        totals += solve(day +1,absent,0,n,dp);
        //choice Add 'A'
        totals += solve(day +1 , absent +1,0,n,dp);
        //choice Add 'L'
        totals += solve(day +1 , absent,late + 1,n,dp);

        return dp[day][absent][late] = totals % mod;
    }
}

//Tabulazation i.e bottom up approach
class solution {
    public int checkRecord(int n) {
    int MOD = 1000000007;
    long[][][] dp = new long[n+1][2][3];

    // Base case
    dp[0][0][0] = 1;

    for (int day = 0; day < n; day++) {
        for (int absent = 0; absent <= 1; absent++) {
            for (int late = 0; late <= 2; late++) {
                long curr = dp[day][absent][late];
                if (curr == 0) continue;

                // Choice 1: Add 'P'
                dp[day+1][absent][0] = (dp[day+1][absent][0] + curr) % MOD;

                // Choice 2: Add 'A'
                if (absent < 1) {
                    dp[day+1][absent+1][0] = (dp[day+1][absent+1][0] + curr) % MOD;
                }

                // Choice 3: Add 'L'
                if (late < 2) {
                    dp[day+1][absent][late+1] = (dp[day+1][absent][late+1] + curr) % MOD;
                }
            }
        }
    }

    long result = 0;
    for (int absent = 0; absent <= 1; absent++) {
        for (int late = 0; late <= 2; late++) {
            result = (result + dp[n][absent][late]) % MOD;
        }
    }

    return (int) result;
}

}