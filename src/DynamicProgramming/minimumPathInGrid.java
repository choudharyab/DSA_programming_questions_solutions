package DynamicProgramming;

import java.util.Arrays;

public class minimumPathInGrid {
    public  static int  minPathSumrec(int [][] grid){
        int m = grid.length;
        int n = grid[0].length;
        return path(m-1 , n-1 , grid);

    }

    public  static int minPathSum(int [][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int row[]:dp) {
            Arrays.fill(row,-1);
        }
        dp[0][0] = grid[0][0];
        for(int i=1 ;i< m;i++) dp[i][0] = grid[i][0] + dp[i-1][0];
        for(int j=1; j< n ;j++) dp[0][j] = grid[0][j] + dp[0][j-1];

        for(int i=1 ;i< m ;i++){
            for(int j=1;j< n;j++){
                int left = grid[i][j] + dp[i][j-1];
                int up = grid[i][j] + dp[i-1][j];
                dp[i][j] =Math.min(left,up);

            }
        }

        return dp[m-1][n-1];
    }

    public static int path(int m , int n , int[][] grid){
        if(m == 0 &&  n == 0) return grid[0][0];

        if(m < 0 || n < 0) return (int) 1e9;

        int up = grid[m][n] + path(m-1 , n , grid);
        int down = grid[m][n] + path(m, n-1 , grid);

        return Math.min(up,down);
    }
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int ans = minPathSum(grid);
        System.out.println("minimum path in grid "+ ans);
    }
}
