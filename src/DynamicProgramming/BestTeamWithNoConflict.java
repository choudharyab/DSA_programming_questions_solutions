//https://leetcode.com/problems/best-team-with-no-conflicts/description/
/*Recursion */
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        List<int[]> ageSort = new ArrayList<>();
        for(int i = 0 ; i< ages.length;i++){
            ageSort.add(new int [] {ages[i],scores[i]});
        }

        ageSort.sort((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]); // if age same, sort by score
            }
            return Integer.compare(a[0], b[0]); // otherwise sort by age
        });

        return solve(ageSort,0,-1);
    }

    private int solve(List<int[]> ageSort , int i , int prev){
        if(i == ageSort.size()) return 0 ;
        int not_take = solve(ageSort,i+1 ,prev); //skip current player;

        int take = 0 ; //take current player
        if(prev == - 1 || ageSort.get(i)[1] >= ageSort.get(prev)[1]){
            take = ageSort.get(i)[1] + solve(ageSort , i+1,i);
        }

        return Math.max(not_take,take);

    }
}

/*Memoziation */
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        Integer [][] dp = new Integer[scores.length][scores.length + 1];
        List<int[]> ageSort = new ArrayList<>();
        for(int i = 0 ; i< ages.length;i++){
            ageSort.add(new int [] {ages[i],scores[i]});
        }

        ageSort.sort((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]); // if age same, sort by score
            }
            return Integer.compare(a[0], b[0]); // otherwise sort by age
        });

        return solve(ageSort,0,-1,dp);
    }

    private int solve(List<int[]> ageSort , int i , int prev,Integer [][] dp){
        if(i == ageSort.size()) return 0 ;

        if(dp[i][prev+1] != null) return dp[i][prev + 1];
        int not_take = solve(ageSort,i+1 ,prev,dp); //skip current player;

        int take = 0 ; //take current player
        if(prev == - 1 || ageSort.get(i)[1] >= ageSort.get(prev)[1]){
            take = ageSort.get(i)[1] + solve(ageSort , i+1,i,dp);
        }

        return dp[i][prev+1] = Math.max(not_take,take);

    }
}

/*Tabulation */
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        List<int[]> ageSort = new ArrayList<>();
        for(int i = 0 ; i< ages.length;i++){
            ageSort.add(new int [] {ages[i],scores[i]});
        }

        ageSort.sort((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]); // if age same, sort by score
            }
            return Integer.compare(a[0], b[0]); // otherwise sort by age
        });
        int [] dp = new int[scores.length];
        int ans = 0;
        for(int i = 0 ; i< scores.length;i++){
            dp[i] = ageSort.get(i)[1];
            for(int j = 0 ; j < i ;j++){
                if(ageSort.get(i)[1] >= ageSort.get(j)[1]){
                    dp[i] = Math.max(dp[i],ageSort.get(i)[1] + dp[j]);
                }
            }
            ans = Math.max(ans,dp[i]);

        }
        return ans;
    }

    
}