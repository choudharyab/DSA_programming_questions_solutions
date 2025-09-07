//https://leetcode.com/problems/reducing-dishes/
/*Recursion */
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        return solve(satisfaction, 0 , 1);
    }

    private int solve(int [] satisfaction , int idx , int time){
        if( idx == satisfaction.length) return 0;

        int not_take = solve(satisfaction ,idx + 1 , time);
        int take = satisfaction[idx] * time + solve(satisfaction , idx+1 , time +1);

        return Math.max(not_take,take);

    }
}

/*Memoziation */
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int [][] t = new int[satisfaction.length + 1][satisfaction.length + 1];
        for(int [] row : t){
            Arrays.fill(row, -1);
        }
        return solve(satisfaction, 0 , 1,t);
    }

    private int solve(int [] satisfaction , int idx , int time,int [][] t){
        if( idx == satisfaction.length) return 0;

        if(t[idx][time] != -1) return t[idx][time];

        int not_take = solve(satisfaction ,idx + 1 , time,t);
        int take = satisfaction[idx] * time + solve(satisfaction , idx+1 , time +1,t);

        return t[idx][time] = Math.max(not_take,take);

    }
}

/*Tabulazation */
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int [][] t = new int[satisfaction.length + 1][satisfaction.length + 2];
        for(int idx = satisfaction.length - 1 ; idx >= 0 ;idx--){
            for( int time = satisfaction.length ;time >= 1 ; time--){
                int not_take = t[idx+1][time];
                int take = satisfaction[idx] * time + t[idx+1][time +1];
                t[idx][time] = Math.max(not_take , take);   
            }
        }

        return t[0][1];
    }

}