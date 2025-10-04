//https://leetcode.com/problems/fruit-into-baskets/description/
class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer,Integer> count = new HashMap<>();
        int left = 0 ;
        int res = 0;
        int distinct = 0;
        int k = 2;

        for(int right = 0 ; right < n ;right++){
            count.put(fruits[right],count.getOrDefault(fruits[right],0) + 1);
            if(count.get(fruits[right]) == 1) distinct++;

            while(distinct > k){
                int leftNum = fruits[left];
                count.put(fruits[left],count.get(fruits[left]) -1);
                if(count.get(fruits[left]) == 0) distinct--;
                left++;
            }
            res = Math.max(res, right - left + 1);

        }
        return res;
        
    }
}