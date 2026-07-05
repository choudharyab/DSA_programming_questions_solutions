//https://leetcode.com/problems/number-of-paths-with-max-score/description/?envType=daily-question&envId=2026-07-05

class Solution {
    static class Pair {
        private int score;
        private int ways;

        Pair(int score , int ways){
            this.score = score;
            this.ways = ways;
        }
    }
    int MOD = 1_000_000_007;
    Pair[][] memo;
    boolean[][] visited;
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        memo = new Pair[n][n];
        visited = new boolean[n][n];

        Pair ans = dfs(board, n-1,n-1);
        if(ans.ways == 0) return new int [] {0,0};
        return new int []{ans.score,ans.ways};
        
    }

    private Pair dfs(List<String> board, int i , int j){
        if( i < 0 || j < 0) return new  Pair (Integer.MIN_VALUE,0);

        char ch = board.get(i).charAt(j);

        if(ch == 'X') return new Pair(Integer.MIN_VALUE,0);

        if(ch == 'E') return new Pair(0,1);

        if(visited[i][j]) return memo[i][j];

        Pair up = dfs(board,i-1,j);
        Pair left = dfs(board,i,j-1);
        Pair diag = dfs(board,i-1,j-1);

        int best = Math.max(up.score,Math.max(left.score,diag.score));

        if(best == Integer.MIN_VALUE) {
            visited[i][j] = true;
            memo[i][j] = new Pair(Integer.MIN_VALUE,0);
            return memo[i][j];
        }

        int ways = 0;
        if(up.score == best){
            ways = (ways + up.ways) % MOD;
        }
        if(left.score == best){
            ways = (ways + left.ways) % MOD;
        }
        if(diag.score == best){
            ways = (ways + diag.ways) % MOD;
        }

        int value = 0;
        if(ch != 'S'){
            value = ch -'0';
        }

        visited[i][j] = true;
        memo[i][j] = new Pair(best + value,ways);
        

        return memo[i][j];


    }
}


/*Bottom Up Approach */
class Solution {

    public int[] pathsWithMaxScore(List<String> board) {

        int n = board.size();
        int MOD = 1_000_000_007;

        int[][] score = new int[n][n];
        int[][] ways = new int[n][n];

        for (int[] row : score)
            Arrays.fill(row, -1);

        score[n - 1][n - 1] = 0;
        ways[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 0; j--) {

                char ch = board.get(i).charAt(j);

                if (ch == 'X')
                    continue;

                if (i == n - 1 && j == n - 1)
                    continue;

                int best = -1;
                int count = 0;

                int[][] dir = {{1, 0}, {0, 1}, {1, 1}};

                for (int[] d : dir) {

                    int ni = i + d[0];
                    int nj = j + d[1];

                    if (ni >= n || nj >= n)
                        continue;

                    if (score[ni][nj] == -1)
                        continue;

                    if (score[ni][nj] > best) {
                        best = score[ni][nj];
                        count = ways[ni][nj];
                    } else if (score[ni][nj] == best) {
                        count = (count + ways[ni][nj]) % MOD;
                    }
                }

                if (best == -1)
                    continue;

                int value = 0;

                if (ch != 'E')
                    value = (ch == 'S') ? 0 : ch - '0';

                score[i][j] = best + value;
                ways[i][j] = count;
            }
        }

        if (ways[0][0] == 0)
            return new int[]{0, 0};

        return new int[]{score[0][0], ways[0][0]};
    }
}