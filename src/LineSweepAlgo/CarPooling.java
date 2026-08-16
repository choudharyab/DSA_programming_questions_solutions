//https://leetcode.com/problems/car-pooling/description/

/*Line Sweep Algorithm */
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        List<int[]> events = new ArrayList<>();
        for(int [] trip : trips){
            events.add(new int[]{trip[1],trip[0]});
            events.add(new int[]{trip[2],-trip[0]});
        }

        Collections.sort(events,(a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int passengerCount = 0;
        for(int [] e: events){
            passengerCount += e[1];
            if(passengerCount > capacity) return false;
        }
        return true;
    }
}

/*Priority Queue */
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        Arrays.sort(trips,Comparator.comparingInt(a -> a[1]));
        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(a ->a[0]));
        int currentPassengers = 0;
        for(int [] trip : trips){
            int passenger = trip[0];
            int from = trip[1];
            int to = trip[2];

            while(!que.isEmpty() && que.peek()[0] <= from){
                currentPassengers -= que.poll()[1];

            }
            currentPassengers += passenger;
            que.offer(new int[] {to,passenger});
            if(currentPassengers > capacity) return false;
        
        }

        return true;

        
    }
}