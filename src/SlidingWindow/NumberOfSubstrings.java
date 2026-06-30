//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/?envType=daily-question&envId=2026-06-30

class Solution {
    public int numberOfSubstrings(String s) {
        int [] count = new int[3];
        int result = 0 ;
        int left = 0;

        for(int right = 0 ; right < s.length() ;right++){
            count[s.charAt(right) - 'a']++;

            while(count[0] > 0 && count[1] > 0 && count[2] > 0){
                count[s.charAt(left) - 'a']--;
                left++;

            }
            result += left;

        }

        return result;
        
    }
}

/*
Algorithm

Initialize a frequency array count[3] for 'a', 'b', 'c', and left = 0, result = 0.
Iterate right from 0 to n-1:

Increment count[s[right] - 'a'].
While all three counts are > 0 (window has all 3 chars):

Decrement count[s[left] - 'a'].
Increment left.


After the loop, the window [left, right] is the first invalid window (or left is one past the last valid start), so add left to result (number of valid windows ending at right is exactly left).


Return result.




 */