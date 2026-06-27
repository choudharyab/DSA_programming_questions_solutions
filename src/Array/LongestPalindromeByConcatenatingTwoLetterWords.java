//https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/description/

/*
  Pattern 
  Frequency Map + Pair Counting (Palindrome / Symmetric)
 */

class Solution {
    public int longestPalindrome(String[] words) {
        Map<String,Integer> freq = new HashMap<>();
        for(String word : words){
            freq.put(word,freq.getOrDefault(word,0)+1);
        }

        int res = 0 ;
        boolean centerUsed = false;


        for(String word : freq.keySet()){
            int wordCount = freq.get(word);
            if(wordCount == 0 ) continue;
            String pair = new StringBuilder(word).reverse().toString();

            if(word.equals(pair)){
                res += (wordCount /2 ) * 4;
                if(wordCount % 2 == 1 && !centerUsed){
                    res +=2;
                    centerUsed = true;
                }
            }else if(freq.containsKey(pair) && freq.get(pair) > 0){
                int matched = Math.min(wordCount,freq.get(pair));
                res += matched * 4;
                freq.put(word,0);
                freq.put(pair,0);
            }
        }

        return res;
        
    }
}