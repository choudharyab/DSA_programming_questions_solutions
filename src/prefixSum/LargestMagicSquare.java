//https://leetcode.com/problems/largest-magic-square/description/?envType=daily-question&envId=2026-01-18


class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int [][] row = new int[n][m+1];
        int [][] col = new int[n+1][m];
        int [][] d1 = new int[n+1][m+1];
        int [][] d2 = new int[n+1][m+1];

        for(int i = 0 ; i< n ;i++){
            for(int j = 0 ; j< m ;j++){
                row[i][j+1] = row[i][j] + grid[i][j];
                col[i+1][j] = col[i][j] + grid[i][j];
                d1[i+1][j+1] = d1[i][j] + grid[i][j];
                d2[i+1][j] = d2[i][j+1] + grid[i][j];
            }
        }

        int maxSquare = Math.min(n,m);
        for(int k = maxSquare ; k >= 1 ;k--){
            for(int i = 0 ; i+ k <= n ;i++){
                for(int j = 0 ; j+k <= m ;j++){
                    int target = row[i][ j+k] - row[i][j];
                    boolean ok = true;

                    //rows
                    for(int r = i ; r < i+k ;r++){
                        int sum = row[r][j + k] - row[r][j];
                        if(sum != target){
                            ok = false;
                            break;
                        }

                    }

                    //cols
                    for(int c = j ; c < j+k && ok ;c++){
                        int sum = col[i+k][c] - col[i][c];
                        if(sum != target){
                            ok = false;
                            break;
                        }

                    }

                    //diagonals
                    if(ok){
                        int diag1 = d1[i + k][j + k] - d1[i][j];
                        int diag2 = d2[i + k][j] - d2[i][j + k];
                        if (diag1 != target || diag2 != target) ok = false;
                    }

                    if(ok) return k;
                }
            }
        }
        return 1;
        
    }
}