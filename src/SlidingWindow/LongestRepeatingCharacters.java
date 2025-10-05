//https://leetcode.com/problems/longest-repeating-character-replacement/description/?envType=problem-list-v2&envId=sliding-window
class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int [] count = new int[26];
        int maxCount = 0 ;
        int maxLength = 0;
        int left = 0 ;


        for(int right = 0 ; right < n ;right++){
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount , count[s.charAt(right) - 'A']); 
            
           // If replacements needed > k, shrink from left
            while((right - left +1) - maxCount > k){
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength , right - left +1);
        }
        return maxLength;
        
    }
}

/* Example Explanlation */
| Step                                        | Window (`s[left..right]`) | Count of Chars | `maxCount` | Window Length | Replacements Needed = (len - maxCount) | Valid?   | Action           | `maxLength` |
| ------------------------------------------- | ------------------------- | -------------- | ---------- | ------------- | -------------------------------------- | -------- | ---------------- | ----------- |
| 1                                           | `A`                       | A:1            | 1          | 1             | 0                                      | ✅        | Expand           | 1           |
| 2                                           | `AA`                      | A:2            | 2          | 2             | 0                                      | ✅        | Expand           | 2           |
| 3                                           | `AAB`                     | A:2, B:1       | 2          | 3             | 1                                      | ✅ (≤1)   | Expand           | 3           |
| 4                                           | `AABA`                    | A:3, B:1       | 3          | 4             | 1                                      | ✅ (≤1)   | Expand           | **4**       |
| 5                                           | `AABAB`                   | A:3, B:2       | 3          | 5             | 2                                      | ❌ (>1)   | Shrink from left | 4           |
| → After shrinking: window = `ABAB` (left=1) | A:2, B:2                  | 3 (unchanged)  | 4          | 1             | ✅                                      | Continue | 4                |             |
| 6                                           | `ABABB`                   | A:2, B:3       | 3          | 5             | 2                                      | ❌        | Shrink           | 4           |
| → After shrinking: window = `BABB` (left=2) | A:1, B:3                  | 3              | 4          | 1             | ✅                                      | Continue | 4                |             |
| 7                                           | `BABBA`                   | A:2, B:3       | 3          | 5             | 2                                      | ❌        | Shrink           | 4           |
| → After shrinking: window = `ABBA` (left=3) | A:2, B:2                  | 3              | 4          | 1             | ✅                                      | Continue | **4**            |             |
