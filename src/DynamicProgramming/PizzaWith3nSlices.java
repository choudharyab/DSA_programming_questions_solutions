//https://leetcode.com/problems/pizza-with-3n-slices/submissions/1762375468/
/*Recursion */
class Solution {
    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        int firstCase = solve(0,n-2,slices,n/3);
        int secondCase = solve(1, n-1, slices, n/3);
        return Math.max(firstCase,secondCase);
    }

    private int solve(int idx , int endIdx, int [] slices , int maxLeft){
        if( maxLeft == 0 || idx > endIdx) return 0;
        
        int take = slices[idx] + solve(idx +2 , endIdx , slices , maxLeft -1);
        int not_take = solve(idx +1, endIdx, slices,maxLeft);

        return Math.max(take,not_take);
    }
}


/*Memoization */
class Solution {
    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        int[][] t1 = new int[n][n/3 + 1];
        int[][] t2 = new int[n][n/3 + 1];

        for (int[] row : t1) Arrays.fill(row, -1);
        for (int[] row : t2) Arrays.fill(row, -1);
        int firstCase = solve(0,n-2,slices,n/3,t1);
        int secondCase = solve(1, n-1, slices, n/3,t2);
        return Math.max(firstCase,secondCase);
    }

    private int solve(int idx , int endIdx, int [] slices , int maxLeft, int [][] t){
        if( maxLeft == 0 || idx > endIdx) return 0;

        if(t[idx][maxLeft] != -1) return t[idx][maxLeft];
        
        int take = slices[idx] + solve(idx +2 , endIdx , slices , maxLeft -1,t);
        int not_take = solve(idx +1, endIdx, slices,maxLeft,t);

        return t[idx][maxLeft] = Math.max(take,not_take);
    }
}

/*Tabulazation */
class Solution {
    public int maxSizeSlices(int[] slices) {
        int k = slices.length;
        int[][] t1 = new int[k +2][k/3 + 1];
        int[][] t2 = new int[k + 2][k/3 + 1];
        
         for(int idx = k-2 ; idx >= 0 ; idx--){
            for(int n = 1 ; n <= k/3 ; n++){
                int take = slices[idx] + t1[idx +2][n -1];
                int not_take = t1[idx +1][n];
                t1[idx][n] = Math.max(take,not_take);
            }
        }
        
        for(int idx = k-1 ; idx >= 1 ; idx--){
            for(int n = 1 ; n <= k/3 ; n++){
                int take = slices[idx] + t2[idx +2][n -1];
                int not_take = t2[idx +1][n];
                t2[idx][n] = Math.max(take,not_take);
            }
        }

        return Math.max(t1[0][k/3] , t2[1][k/3]);
    }
}