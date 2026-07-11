
//https://leetcode.com/problems/max-area-of-island/
class Solution {
    private int [][] grid;
    private int rows;
    private int cols;
    private int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;

        for(int row = 0 ; row < rows;row++){
            for(int col = 0 ; col < cols ;col++){
                if(grid[row][col] == 1){
                   int count = dfs(row,col);
                   maxArea = Math.max(maxArea,count);

                }
            }
        }

        return maxArea;
    }

    private int dfs(int row , int col){
        if(row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) return 0;

        grid[row][col] = 0;
        return 1 + dfs(row+1,col) + dfs(row-1,col) + dfs(row,col+1) + dfs(row,col-1);

    }
}