//https://leetcode.com/problems/my-calendar-iii/description/?envType=problem-list-v2&envId=mzw3cyy6
class MyCalendarThree {
    private List<int[]> events;

    public MyCalendarThree() {
        events = new ArrayList<>();
    }
    
    public int book(int startTime, int endTime) {
        List<int[]> temp = new ArrayList<>(events);

        temp.add(new int[]{startTime,1});
        temp.add(new int[]{endTime,-1});

        Collections.sort(temp,(a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int count = 0 ;
        int booking = 0;

        for(int [] e : temp){
            count += e[1];
            if(count > booking){
                booking = count; 
            }
        }

        events = temp;
        return booking;


        
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */