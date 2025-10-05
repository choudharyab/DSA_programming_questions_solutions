//https://leetcode.com/problems/pacific-atlantic-water-flow/description/?envType=daily-question&envId=2025-10-05
/*DFS */
class Solution {
    private int [][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean [][] pacificOceans = new boolean[m][n];
        boolean [][] atlanticOceans = new boolean[m][n];

        for(int i = 0 ; i< m ;i++){
            dfs(heights,pacificOceans,i,0,Integer.MIN_VALUE); // left edge
            dfs(heights,atlanticOceans,i,n-1,Integer.MIN_VALUE);  // right edge
        }

        for(int j = 0 ; j< n ;j++){
            dfs(heights,pacificOceans,0,j,Integer.MIN_VALUE); // top edge
            dfs(heights,atlanticOceans,m-1,j,Integer.MIN_VALUE);  // bottom edge
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i< m ;i++){
            for(int j = 0 ; j < n ;j++){
                if(pacificOceans[i][j] && atlanticOceans[i][j]){
                    result.add(Arrays.asList(i,j));

                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights , boolean [][] visited , int r , int c , int prevHeight){
        if(r < 0 || c < 0 || r >= heights.length || c >= heights[0].length || visited[r][c] || heights[r][c] < prevHeight) return;

        visited[r][c] = true;
        for(int [] dirs : dir){
            int nr = r + dirs[0];
            int nc = c + dirs[1];

            dfs(heights,visited,nr,nc,heights[r][c]);
        }

    }
}

/*BFS */
class Solution {
    private static final int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    private int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        // Pacific (top + left edges)
        for (int i = 0; i < m; i++) {
            pacificQueue.offer(new int[]{i, 0});
            pacific[i][0] = true;
            atlanticQueue.offer(new int[]{i, n - 1});
            atlantic[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pacificQueue.offer(new int[]{0, j});
            pacific[0][j] = true;
            atlanticQueue.offer(new int[]{m - 1, j});
            atlantic[m - 1][j] = true;
        }

        bfs(heights, pacificQueue, pacific);
        bfs(heights, atlanticQueue, atlantic);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited) {
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n
                        && !visited[nr][nc]
                        && heights[nr][nc] >= heights[r][c]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
