
//https://leetcode.com/problems/describe-the-painting/description/?envType=problem-list-v2&envId=mzw3cyy6
class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        List<int[]> events = new ArrayList<>();
        for(int [] seg : segments){
            events.add(new int[]{seg[0],seg[2]});
            events.add(new int[]{seg[1],-seg[2]});
        }

        Collections.sort(events,(a,b)-> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        List<List<Long>> results = new ArrayList<>();
        long sum = events.get(0)[1];
        int prev = events.get(0)[0];

        for(int i = 1  ; i< events.size();i++){
            int current = events.get(i)[0];
            if(prev !=  current){
                if(sum > 0){
                    results.add(Arrays.asList((long) prev,(long) current,sum));
                }
                prev = current;
            }
            sum += events.get(i)[1];
            
        }

        return results;

        
    }
}