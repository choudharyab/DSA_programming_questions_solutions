//https://leetcode.com/problems/surrounded-regions/submissions/2063543091/

class Solution {
    private char[][] board;
    private int rows;
    private int cols;
    public void solve(char[][] board) {
        this.board = board;
        this.rows= board.length;
        this.cols = board[0].length;

        for(int row = 0 ;row < rows;row++){
            for(int col = 0 ; col < cols;col++){
                if(( row == 0 || row == rows -1 || col == 0 || col == cols-1 ) && board[row][col] == 'O'){
                    dfs(row,col);
                }
            }
        }

        for(int row = 0 ;row < rows;row++){
            for(int col = 0 ; col < cols;col++){
                if(board[row][col] == 'O'){
                    board[row][col] = 'X';
                }else if(board[row][col] == '.'){
                    board[row][col] = 'O';
                }
            }
        }
    }


    private void dfs(int row , int col){
        if( row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != 'O') return;
        board[row][col] = '.';
        dfs(row +1,col);
        dfs(row-1,col);
        dfs(row,col+1);
        dfs(row,col-1);
    }
}

/*
 T.c -> 0(m * n)
 s.c -> 0(1)
 */