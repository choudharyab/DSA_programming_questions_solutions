//https://neetcode.io/problems/non-overlapping-intervals/question?list=neetcode150
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        int [] current = intervals[0];
        int count = 0;

        for(int i = 1 ; i < intervals.length;i++){
            if(current[1] > intervals[i][0]){
                count++;
                //keeps the intervals at end earlier
                if(intervals[i][1] < current[1]){
                    current = intervals[i];
                }
            }else{
                current = intervals[i];
            }
        }

        return count;
        
    }
}
