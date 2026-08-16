//https://leetcode.com/problems/my-calendar-ii/
/*
 Time complexity -> Time = O(n log n)
 Space = O(n)
 */
class MyCalendarTwo {
    private List<int[]> events;
    
    public MyCalendarTwo() {
        events = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        //copying the existing events
        List<int[]> temp = new ArrayList<>(events);
      
        //adding new booking events
        temp.add(new int []{startTime,1});
        temp.add(new int []{endTime,-1});

        //sort the events
        Collections.sort(temp,(a,b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]); //end before start at same time
        });

        int count = 0 ;

        for(int [] e : temp){
            count+= e[1];
            if(count > 2){
                return false;
            }
        }

        events = temp;
        

        return true;
        
        
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */