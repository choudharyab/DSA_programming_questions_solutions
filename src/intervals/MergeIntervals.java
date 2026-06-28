//https://neetcode.io/problems/merge-intervals/question

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length ;
        int[] current = intervals[0];

        for(int i = 1 ; i<n ;i++){
            if(current[1] >= intervals[i][0]){ //merge
                current[1] = Math.max(current[1],intervals[i][1]);
            }else {
                ans.add(current);
                current = intervals[i];
            }

        }

        ans.add(current);


    
        
        return ans.toArray(new int[ans.size()][]);
        
    }
}
