//https://leetcode.com/problems/maximum-total-damage-with-spell-casting/description/?envType=daily-question&envId=2025-10-11
class Solution {
    public long maximumTotalDamage(int[] power) {
        //Step 1 count the frequency of number
        Map<Long,Long> map = new HashMap<>();
        for(int row : power){
            map.put((long) row , map.getOrDefault((long) row ,0L) + 1);
        }

        //step 2 sort distinct damage values
        List<Long> damages = new ArrayList<>(map.keySet());
        Collections.sort(damages);

        int n = damages.size();
        long [] dp = new long[n+1]; // o to end

        for(int i = n- 1 ; i>=0 ;i--){
            long currentDamage = damages.get(i);
            long totalDamageIfTaken = currentDamage  * map.get(currentDamage);

            int nextIndex = findNextIndex(damages, currentDamage +2);
            long take = totalDamageIfTaken + dp[nextIndex];
            long skip = dp[i+1];
            dp[i] = Math.max(take, skip);

        }

        return dp[0];
        
    }

     // Binary search helper
    private int findNextIndex(List<Long> damages, long minValue) {
        int low = 0, high = damages.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (damages.get(mid) <= minValue) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

/*
T.C -> O(nlogn)
S.C -> 0(n)
 */