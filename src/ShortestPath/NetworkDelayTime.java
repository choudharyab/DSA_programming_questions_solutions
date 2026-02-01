//https://leetcode.com/problems/network-delay-time/description/?envType=problem-list-v2&envId=shortest-path
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int []>> graph = new HashMap<>();
        for(int [] edge : times){
            int u = edge[0],v = edge[1] , w = edge[2];
            graph.putIfAbsent(u,new ArrayList<>());
            graph.get(u).add(new int [] {v,w});
        }
        return dijkstra(graph,k,n);
    }

     private static int dijkstra(Map<Integer,List<int []>> graph, int src,int n) {
        int [] distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        //pair with (v,d)
        PriorityQueue<int []> queue = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        distance[src] = 0 ;
        queue.offer(new int[]{src,0});
        while (!queue.isEmpty()){
            int [] nodes = queue.poll();
            int u = nodes[0];
            int d = nodes[1];
            if(d > distance[u]) continue;

            List<int[]> neighbours = graph.getOrDefault(u, new ArrayList<>());

            for (int [] pair : neighbours){
                int v = pair[0];
                int w = pair[1];
                if( d + w < distance[v]){
                    distance[v] = d + w;
                    queue.offer(new int [] {v,distance[v]});
                }
            }

        }
        int maxDist = Arrays.stream(distance).skip(1).max().getAsInt();
        return maxDist == Integer.MAX_VALUE ? -1 : maxDist;
    }
}