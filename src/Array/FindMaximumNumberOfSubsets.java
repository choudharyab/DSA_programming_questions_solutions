//https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/description/?envType=daily-question&envId=2026-06-27
/*
You are given an array of positive integers nums.

You need to select a subset of nums which satisfies the following condition:

You can place the selected elements in a 0-indexed array such that it follows the pattern: [x, x2, x4, ..., xk/2, xk, xk/2, ..., x4, x2, x] (Note that k can be be any non-negative power of 2). For example, [2, 4, 16, 4, 2] and [3, 9, 3] follow the pattern while [2, 4, 8, 4, 2] does not.
Return the maximum number of elements in a subset that satisfies these conditions

 */

/* code 
  Time complexity : 0(n log(max_val)) for each unique x, the chain length is at most log₂(log₂(10⁹)) ≈ 5 levels (since squaring grows extremely fast: 2 → 4 → 16 → 256 → 65536 → ...). So effectively O(n).
Space: O(n) for the frequency map
 */ 
class Solution {
    public int maximumLength(int[] nums) {
        //calculate the frequency
        Map<Long,Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.merge((long) num, 1 ,Integer::sum);
        }

        int ans = 1;

        //handle the special case for 1
        if(freq.containsKey(1L)){
            int cnt = freq.get(1L);
            ans = Math.max(ans,cnt % 2 == 1 ? cnt : cnt -1); //length must be odd
        }

        for(long x : freq.keySet()){
            if(x == 1) continue;

            int len = 0 ;
            long curr = x ;
            while(freq.getOrDefault(curr,0) >= 2){
                len += 2;
                curr = curr * curr;

                if( curr > 1000000000L) break;
            }

            if(freq.getOrDefault(curr,0) >= 1){
                len += 1;
            } else if( len > 0){
                len -= 1;
            }

            ans = Math.max(ans,len);
        }

        return ans;
        
    }
}

/*
Dry Run
Input: nums = [5, 4, 1, 2, 2]
Freq map: {5:1, 4:1, 1:1, 2:2}

x = 1: count = 1 (odd) → candidate = 1.
x = 5: freq[5]=1 < 2 → len=0, center? freq[5]=1 → len=1. Candidate=1.
x = 4: freq[4]=1 < 2 → len=0, center? freq[4]=1 → len=1. Candidate=1.
x = 2: freq[2]=2 ≥ 2 → len=2, cur=4. freq[4]=1 < 2 → stop. Center? freq[4]=1 → len=3. Candidate=3. ✅

Answer: 3 → arrangement [2, 4, 2]


Input: nums = [1, 3, 2, 4]
Freq: {1:1, 3:1, 2:1, 4:1}

x=1: cnt=1 (odd) → candidate=1.
All others: freq < 2 everywhere, center exists → each gives len=1.

Answer: 1


Edge Cases
CaseHandlingAll 1s ([1,1,1,1])cnt=4 even → answer = 3 (drop one to make odd)
Single elementBaseline ans=1 covers it
x=2, chain 2→4→16→256 all with freq≥2Each level adds 2; 
last level adds 1 centerLarge values squaring to overflowGuard cur > 1e18 breaks the loop safely
No pair exists for any xEach element is a singleton → answer = 1

 */