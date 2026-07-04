//https://leetcode.com/problems/network-recovery-pathways/description/
class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        int l = Integer.MAX_VALUE;
        int r = 0;
        Map<Integer,List<int[]>> adj = new HashMap<>();

        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if(!online[u] || !online[v]) continue;

            //create adj list
            adj.computeIfAbsent(u ,x -> new ArrayList<>()).add(new int [] {v,w});
            l = Math.min(l,w);
            r = Math.max(r,w);
        }

        int ans = -1 ;
        while( l <= r){
            int mid = l +(r-l)/2;
            if(checkShortestPath(mid,n,k,adj)){
                ans = mid;
                l = mid + 1;
            }else {
                r = mid -1;
            }
        }

        return ans;
        
    }

    private boolean checkShortestPath(int mid , int n , long k , Map<Integer,List<int[]>> adj){
        long [] result = new long[n];
        Arrays.fill(result,Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[0],b[0])); //compare cost
        result[0] = 0;
        pq.offer(new long[]{0,0});

        while(!pq.isEmpty()){
            long [] top = pq.poll();
            long cost = top[0];
            int node = (int) top[1];

            if(cost > k) continue;
            if(node == n -1) return true;

            if(cost > result[node]) continue;

            for(int [] next : adj.getOrDefault(node,Collections.emptyList())){
                int nexCost = next[1];
                int nextNode = next[0];

                if(nexCost < mid) continue;

                if( cost + nexCost < result[nextNode]){
                    result[nextNode] = cost + nexCost;
                    pq.offer(new long [] {cost + nexCost,nextNode});
                }

            }
        }

        return false;

    }
}


/*
//T.C : O((E+V)log(V) * log(U)), E = number of edges, V = number of vertices, (E+V)log(V) is for Dijkstra and log(U) is for Binary Search, U = r-l;
//S.C : O(V+E)

Pattern -> dijiskrata algo + binary search
 */