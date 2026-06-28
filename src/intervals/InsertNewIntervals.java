//https://neetcode.io/problems/insert-new-interval/question

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int i = 0 ;
        int n = intervals.length;

        //add interval before new interval
        while( i < n && intervals[i][1] < newInterval[0]){
            ans.add(intervals[i]);
            i++;
        }

        //overlap merge the interval
        while( i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }

        ans.add(newInterval);
        
        //adding the remaing intervals
        while( i < n){
            ans.add(intervals[i]);
            i++;

        }


        return ans.toArray(new int[ans.size()][]);
    }
}

/*
T.c-> 0(n) S.c -> 0(n)
The pattern to remember is always:

Before overlap → Copy as-is.
Overlap → Merge.
After overlap → Copy as-is.
 */