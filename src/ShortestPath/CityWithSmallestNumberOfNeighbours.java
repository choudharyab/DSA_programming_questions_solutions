//https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/?envType=problem-list-v2&envId=shortest-path
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<int []>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for(int [] edge : edges){  // birectorial graph
            adj[edge[0]].add(new int[]{edge[1],edge[2]});
            adj[edge[1]].add(new int[]{edge[0],edge[2]});
        }
        int resultCity = -1 ;
        int minReachable = Integer.MAX_VALUE;

        for(int city = 0 ; city < n ;city++){
            int [] dist = new int[n];
            Arrays.fill(dist,Integer.MAX_VALUE);
            PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);  //min value at top
            dist[city] = 0 ;
            pq.offer(new int[]{0,city});

            while (!pq.isEmpty()){
                int [] current = pq.poll();
                int currentDist = current[0];
                int currentNode = current[1];

                if(dist[currentNode] > currentDist) continue;

                for(int [] edge : adj[currentNode]){
                    int nextNode = edge[0];
                    int nextDistance = edge[1];

                    if(dist[nextNode] > (nextDistance + currentDist)){
                        dist[nextNode] = nextDistance + currentDist;
                        pq.offer(new int [] {dist[nextNode],nextNode});
                    }
                }
            }
            //count the reachable distance from itself
            int count = 0;
            for(int i = 0 ; i < n ;i++){
                if( i != city && dist[i] <= distanceThreshold){
                    count++;
                }
            }

            System.out.println("count "+count);

            //update the result
            if(count <= minReachable){
                minReachable = count;
                resultCity = city;
            }
        }

        return resultCity;
    
        
    }
}

/*
T.c  -> 0(n * (edges * vertex))
S.c -> 0(vertex + edges)
 */