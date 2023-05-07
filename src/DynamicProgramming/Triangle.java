package DynamicProgramming;

import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/triangle/
public class Triangle {

    static int minimumSumPath(int[][] triangle , int n){
        int [][] dp = new int[n][n];
        for(int row[] :dp){
            Arrays.fill(row ,-1);
        }

        return minimumSumPathCalculate(0,0,triangle,n ,dp);

    }

    static int minimumSumPathCalculate(int i , int j , int [][] triangle , int n , int[][] dp) {
        if(dp[i][j] != -1) return dp[i][j];

        if( i == n-1) return triangle[i][j];

        int down = triangle[i][j] + minimumSumPathCalculate(i+1 , j , triangle , n ,dp);
        int diagonal = triangle[i][j] + minimumSumPathCalculate(i+1,j+1 , triangle,n,dp);

        dp[i] [j] = Math.min(down,diagonal);
        return dp[i][j];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [][] dp = new int[n][n];

        for(int j= 0 ;j< n ;j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        for(int i = n-2 ;i>=0 ;i--){
            for(int j= i ;j>= 0 ;j--){
                int down = triangle.get(i).get(j) +dp[i+1][j];
                int diagonal = triangle.get(i).get(j) + dp[i+1][j+1];

                dp[i][j] = Math.min(down,diagonal);
            }
        }

        return dp[0][0];

    }
    public static void main(String[] args) {
        int [][] triangle = {{2},{3,4},{6,5,7},{4,1,8,3}} ;
        int n = triangle.length;
        int minPath = minimumSumPath(triangle,n);
        System.out.println("Printing ....... " + minPath);
    }
}

/* n =4
*
*
* */
