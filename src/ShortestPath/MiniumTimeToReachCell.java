//https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/?envType=problem-list-v2&envId=shortest-path
class Solution {
    public int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if( m > 1 && n > 1 && grid[0][1] > 1 && grid[1][0] > 1) return -1;
        PriorityQueue<int [] > pq = new PriorityQueue <>((a,b) -> a[0]-b[0]);
        boolean [][] visited = new boolean[m][n];
        pq.offer(new int [] {0,0,0});  //time,rol,col

        int [] dr = {0,1,0,-1};
        int [] dc = {1,0,-1,0};

        while(!pq.isEmpty()){
            int [] curr = pq.poll();
            int time = curr[0];
            int row = curr[1];
            int col = curr[2];

            if(visited[row][col]) continue;
            visited[row][col] = true;

            if(row == m - 1 && col == n -1) return time;

            for(int i = 0 ; i<4 ;i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if( nr < 0 || nc < 0 || nr >= m || nc >= n || visited[nr][nc]) continue;

                int nextTime = time + 1;

                //if cell is not open then wait
                if(nextTime < grid[nr][nc]){
                    int diff = grid[nr][nc] - nextTime;
                    if (diff % 2 == 0) {
                        nextTime = grid[nr][nc];
                    } else {
                        nextTime = grid[nr][nc] + 1;
                    }
                }

                pq.offer(new int []{nextTime, nr,nc});

            }

        }

        return -1;
        
    }
}