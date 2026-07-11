//https://leetcode.com/problems/count-the-number-of-complete-components/description/?envType=daily-question&envId=2026-07-11

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer> [] adj = new ArrayList[n];
        for(int i = 0 ; i < n ;i++){
            adj[i] = new ArrayList<>();
        }

        for(int [] edge : edges){
            int u = edge[0] , v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        
        boolean [] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            
            if(visited[i]){
                continue;
            }
            
            List<Integer> component = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            visited[i] = true;
            
            while(!q.isEmpty()){
                int current = q.poll();
                component.add(current);
                for(int nextNode : adj[current]){
                    if(!visited[nextNode]){
                        visited[nextNode] = true;
                        q.offer(nextNode);
                    }
                }
            }

            int size = component.size();
            boolean complete = true;

            for (int node : component) {
                if (adj[node].size() != size - 1) {
                    complete = false;
                    break;
                }
            }

            if(complete) count++;


        }

        return count;
        
    }
}

/*
  Complexity
Building graph: O(E)
BFS: O(V + E)
Checking completeness: O(V)

Overall:

Time: O(V + E)
Space: O(V + E)

 */