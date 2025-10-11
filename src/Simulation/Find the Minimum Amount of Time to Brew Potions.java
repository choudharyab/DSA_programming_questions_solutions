//https://leetcode.com/problems/find-the-minimum-amount-of-time-to-brew-potions/
class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long [] result = new long[n];

        for(int j = 0 ; j < m ;++j){
            result[0] += (long) skill[0] * mana[j];

            for(int i = 1; i< n ; ++i){
                result[i] = Math.max(result[i],result[i-1]) + (long) skill[i] * mana[j];
            }

            for(int k = n-1 ;k> 0 ;--k){
                result[k-1] = result[k] - skill[k] * mana[j];
            }
        }

        return result[n-1];
        
    }
}

/* T.c -> 0(n *m)
    s.c -> o(n)
 */

