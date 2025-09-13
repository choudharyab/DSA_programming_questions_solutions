//https://leetcode.com/problems/painting-the-walls/submissions/1769001035/
/*Recursion */
class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        return solve(0,n,cost,time);
    }

    private int solve(int idx ,int rem, int [] cost , int [] time){
        if(rem <= 0) return 0;
        if( idx >= cost.length) return Integer.MAX_VALUE/2;

        //case 1 where paid painter not take
        int noTake = solve(idx + 1 ,rem, cost, time);
        int take = cost[idx] + solve(idx +1,rem -1 - time[idx] ,cost,time);

        return Math.min(noTake,take);
    }
}

/*Memomization */
class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        Integer[][] memo = new Integer[n][n + 1];
        return solve(0,n,cost,time,memo);
    }

    private int solve(int idx ,int rem, int [] cost , int [] time,Integer[][] memo){
        if(rem <= 0) return 0;
        if( idx >= cost.length) return Integer.MAX_VALUE/2;

        if(memo[idx][rem] != null) return memo[idx][rem];

        //case 1 where paid painter not take
        int noTake = solve(idx + 1 ,rem, cost, time,memo);
        int take = cost[idx] + solve(idx +1,rem -1 - time[idx] ,cost,time,memo);

        return memo[idx][rem] = Math.min(noTake,take);
    }
}

/*Tabulazation */