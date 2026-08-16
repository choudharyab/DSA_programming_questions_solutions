class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        // code here
        List<int[]> events = new ArrayList<>();
        for(int s : start){
            events.add(new int[]{s,1});
        }
        for(int e : end){
            events.add(new int[]{e,-1});
        }
        
        Collections.sort(events,(a,b) ->{
           if(a[0] == b[0]) return a[1]- b[1];
           return a[0] - b[0];
        });
        
        int overlap = 0;
        int maxOverlap = 0;
        for(int [] e : events){
            overlap += e[1];
            if(overlap > maxOverlap){
                maxOverlap = overlap;
            }
        }
        
        return maxOverlap;
        
    }
}
