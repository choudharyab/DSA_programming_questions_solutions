package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakDp {
    public static boolean wordBreak(String s , List<String> wordDict){
        boolean [] dp = new boolean[s.length() +1] ;
        //Set<String> wordDictSet = new HashSet<>(wordDict);
        dp[0] = true;
        for(int i =1 ;i<=s.length();i++){
            for(int j = 0 ;j< i ;j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        boolean valid = wordBreak(s,wordDict);
        System.out.println(valid);
    }
}
