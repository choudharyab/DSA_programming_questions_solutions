//https://leetcode.com/problems/longest-palindrome/description/

class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> freq = new HashMap<>();
        for(char c : s.toCharArray()){
            freq.put(c, freq.getOrDefault(c,0)+ 1);
        }

        int res = 0 ;
        boolean oddFrequency = false;

        for(char key : freq.keySet()){
            int value  = freq.get(key);
            if(value % 2 == 0){
                res += value;
            }else{
                res += value -1;
                oddFrequency = true;
            }

        }

        if(oddFrequency) res +=1;

        return res;
        
    }
}