//https://leetcode.com/problems/minimum-window-substring/description/?envType=problem-list-v2&envId=sliding-window

class Solution {
    public String minWindow(String s, String t) {
        int countRequired = t.length();
        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch , map.getOrDefault(ch,0) + 1);
        }
        
        int i = 0 , j = 0 ;
        int res = Integer.MAX_VALUE;
        int start = 0 ;
        while( j < n){
            char ch = s.charAt(j);
            if(map.containsKey(ch)) {
                    map.put(ch , map.get(ch) - 1);
                    if(map.get(ch) >= 0){
                        countRequired =  countRequired - 1;
                    }
                while(countRequired == 0){
                    if((j-i+1) < res){
                        res = j-i+1;
                        start = i ;
                    }

                    char leftChar = s.charAt(i);
                    if(map.containsKey(leftChar)){
                        map.put(leftChar, map.get(leftChar) + 1);

                        if((map.get(leftChar)) > 0){
                            countRequired++;
                        }
                    }
                    i++;
                    
                }
                
                
            }
            j++;
        }

        return res == Integer.MAX_VALUE ?  "" : s.substring(start,start+res);
        
    }
}