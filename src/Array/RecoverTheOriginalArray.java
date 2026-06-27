//https://leetcode.com/problems/recover-the-original-array/description/

/*
  Time: O(n² ) — at most O(n) candidate k values, each reconstruction is O(n). With n ≤ 1000, this is 10^6 ops — well within limits.
Space: O(n) for freq map .
 */

class Solution {
    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length / 2;

        for(int i =1 ; i < nums.length ; i++){
            int diff = nums[i] - nums[0];

            if(diff <= 0 || diff % 2 != 0) continue;

            int k = diff / 2;

            Map<Integer,Integer> freq = new HashMap<>();
            for(int num : nums){
                freq.put(num ,freq.getOrDefault(num,0)+1);
            }

            int idx = 0;
            int [] result = new int[n];
            boolean valid = true;

            for(int num : nums){
                if(freq.get(num) == 0) continue;
                int pair = num + 2 * k;
                if(!freq.containsKey(pair) || freq.get(pair) == 0){
                    valid = false;
                    break;
                }
                freq.put(num ,freq.get(num) - 1);
                freq.put(pair , freq.get(pair) - 1);

                result[idx++] = num + k;
            }

            if(valid && idx == n) return result;


        }

        return new int [0];
        
    }
}