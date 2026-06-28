//https://neetcode.io/problems/meeting-schedule/question

/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return true;
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        int n = intervals.size();
        Interval current = intervals.get(0);

        for(int i = 1 ; i < n ;i++){
            if(current.end > intervals.get(i).start) return false;
            current = intervals.get(i);
        }

        return true;

    }
}
