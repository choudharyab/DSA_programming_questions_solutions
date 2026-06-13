//https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-ii/description/
/*
There is an undirected tree with n nodes labeled from 1 to n, rooted at node 1. The tree is represented by a 2D integer array edges of length n - 1, where edges[i] = [ui, vi] indicates that there is an edge between nodes ui and vi.

Initially, all edges have a weight of 0. You must assign each edge a weight of either 1 or 2.

The cost of a path between any two nodes u and v is the total weight of all edges in the path connecting them.

You are given a 2D integer array queries. For each queries[i] = [ui, vi], determine the number of ways to assign weights to edges in the path such that the cost of the path between ui and vi is odd.

Return an array answer, where answer[i] is the number of valid assignments for queries[i].

Since the answer may be large, apply modulo 109 + 7 to each answer[i].

Note: For each query, disregard all edges not in the path between node ui and vi.

Input: edges = [[1,2],[1,3],[3,4],[3,5]], queries = [[1,4],[3,4],[2,5]]

Output: [2,1,4]

Explanation:

Query [1,4]: The path from Node 1 to Node 4 consists of two edges (1 → 3 and 3 → 4). Assigning weights (1,2) or (2,1) results in an odd cost. Thus, the number of valid assignments is 2.
Query [3,4]: The path from Node 3 to Node 4 consists of one edge (3 → 4). Assigning weight 1 makes the cost odd, while 2 makes it even. Thus, the number of valid assignments is 1.
Query [2,5]: The path from Node 2 to Node 5 consists of three edges (2 → 1, 1 → 3, and 3 → 5). Assigning (1,2,2), (2,1,2), (2,2,1), or (1,1,1) makes the cost odd. Thus, the number of valid assignments is 4.
 */
class Solution {
    private int n;
    private List<List<Integer>> adj;
    private int cols;
    private int [][] ancestorTable;
    int [] depth;
    static final long MOD = 1_000_000_007L;
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        n = edges.length + 1;
        cols = (int) (Math.log(n) / Math.log(2)) + 1;
        adj = new ArrayList<>();

        for(int i = 0 ; i< n ;i++){
            adj.add(new ArrayList<>());
        }

        for(int [] edge : edges){
            int u = edge[0] - 1;
            int v = edge[1] - 1;

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        depth = new int[n];
        ancestorTable = new int[n][cols];

        for(int i = 0 ; i< n ;i++){
            for(int j = 0 ; j < cols ;j++){
                ancestorTable[i][j] = -1;
            }
        }

        dfs(0,-1);  // to find the depth
        buildAncestorTable();   //building the ancestor table to find x from node

        int [] results = new int[queries.length];
        for(int i = 0 ; i < queries.length ;i++){
            int u = queries[i][0] - 1;
            int v = queries[i][1] - 1; // making o based compatilabliy

            int lca = LCA(u,v);
            int d = depth[u] + depth[v] - 2 * depth[lca];

            if(d == 0){
                results[i] = 0;
            }else {
                results[i] = (int) modPow(2,d-1);
            }

        }

        return results;



        
    }

    private void dfs(int root, int parent){
        ancestorTable[root][0] = parent;
        for(int neigh : adj.get(root)){
            if(neigh == parent) continue;

            depth[neigh] = depth[root] + 1;
            dfs(neigh,root);
        }
    }

    private void buildAncestorTable(){
        for(int j = 1 ; j < cols ;j++){
            for(int node = 0 ; node < n ;node++){
                int prev = ancestorTable[node][j -1];
                if( prev != -1){
                    ancestorTable[node][j] = ancestorTable[prev][j-1];

                }
            }
        }
    }

    private int LCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int k = depth[u] - depth[v];

        for (int j = 0; j < cols; j++) {
            if ((k & (1 << j)) != 0) {
                u = ancestorTable[u][j];
            }
        }

        if (u == v) {
            return u;
        }

        for (int j = cols - 1; j >= 0; j--) {
            if (ancestorTable[u][j] == -1) {
                continue;
            }

            if (ancestorTable[u][j] != ancestorTable[v][j]) {
                u = ancestorTable[u][j];
                v = ancestorTable[v][j];
            }
        }

        return ancestorTable[u][0];
    }

    private long modPow(long base, long exp) {
    long res = 1;

    while (exp > 0) {
        if ((exp & 1) == 1) {
            res = (res * base) % MOD;
        }

        base = (base * base) % MOD;
        exp >>= 1;
    }

    return res;
}
}