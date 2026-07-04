//https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/description/?envType=daily-question&envId=2026-07-04

class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int [] road : roads){
            int u = road[0],v=road[1],w=road[2];
            graph.get(u).add(new int [] {v,w});
            graph.get(v).add(new int [] {u,w});
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        visited[1] = true;

        int ans = Integer.MAX_VALUE;

        
        while (!q.isEmpty()) {
            int node = q.poll();

            for (int[] edge : graph.get(node)) {
                ans = Math.min(ans, edge[1]);

                if (!visited[edge[0]]) {
                    visited[edge[0]] = true;
                    q.offer(edge[0]);
                }
            }
        }

        return ans;


        
    }

    
}

/*
Complexity
Time: O(n + roads.length)
Space: O(n + roads.length)
 */