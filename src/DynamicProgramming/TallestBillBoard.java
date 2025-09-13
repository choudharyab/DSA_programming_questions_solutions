//https://leetcode.com/problems/tallest-billboard/submissions/1768923718/
/*Recursion */
class Solution {
    public int tallestBillboard(int[] rods) {
        return solve(0,0,0,rods);
    }

    private int solve(int index , int l1 ,int l2 ,int [] rods){
        if(index >= rods.length){
            if( l1 == l2) return l1;
            return 0;
        }
        
        int skip = solve(index +1 , l1,l2,rods);
        int addToL1 = solve(index +1 , l1 + rods[index],l2,rods);
        int addToL2 = solve(index +1 , l1 ,l2 + rods[index],rods);

        return Math.max(skip , Math.max(addToL1,addToL2));
    }
}


/*Memoziation */
class Solution {
    public int tallestBillboard(int[] rods) {
        Map<Integer, Integer>[] memo = new HashMap[rods.length];
        for (int i = 0; i < rods.length; i++) memo[i] = new HashMap<>();
        return solve(0,0,rods,memo)/2;
    }

    private int solve(int index , int diff,int [] rods,Map<Integer, Integer>[] memo){
        if(index >= rods.length){
            if( diff == 0) return 0;
            return Integer.MIN_VALUE;
        }

        if (memo[index].containsKey(diff)) return memo[index].get(diff);
        
        int skip = solve(index +1 , diff,rods,memo);
        int addToL1 = rods[index] + solve(index +1 , diff + rods[index],rods,memo);
        int addToL2 = rods[index] + solve(index +1 ,diff - rods[index],rods,memo);
        memo[index].put(diff,Math.max(skip , Math.max(addToL1,addToL2)));
        return Math.max(skip , Math.max(addToL1,addToL2));
    }
}

/*Tabulazation */
class Solution {
    public int tallestBillboard(int[] rods) {
        Map<Integer,Integer> dp = new HashMap<>();
        dp.put(0 , 0);

        for(int rod : rods){
            Map<Integer,Integer> current = new HashMap<>(dp);
            for(Map.Entry<Integer,Integer> entry : dp.entrySet()){
                int diff = entry.getKey();
                int shorter = entry.getValue();

                //case 1 add rods to taller side
                int newDiff = diff + rod;
                current.put(newDiff,Math.max(current.getOrDefault(newDiff,0),shorter));

                //case 2 add rods to shortest side
                newDiff = Math.abs(diff - rod);
                int newShorter = shorter + Math.min(diff, rod);
                current.put(newDiff,Math.max(current.getOrDefault(newDiff,0),newShorter));
            }
            dp = current;
        }

        return dp.getOrDefault(0,0);
    }
}