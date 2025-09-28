//https://leetcode.com/problems/find-all-anagrams-in-a-string/submissions/1784985498/?envType=problem-list-v2&envId=sliding-window

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int k = p.length();
        List<Integer> result = new ArrayList<>();
        int [] count = new int[26];

        for(char c : p.toCharArray()){
            count[c - 'a']++;
        }

        int i = 0 , j = 0 ;
        while( j < n){
            count[s.charAt(j) - 'a']--;
            if(j-i+1 == k){
                if(countAllZero(count)){
                    result.add(i);
                }
                count[s.charAt(i) - 'a']++;
                i++;
            }
            j++;

        }

        return result;
        
    }

    private boolean countAllZero(int [] count){
        for(int row : count){
            if(row != 0) return false;
        }

        return true;
    }
}