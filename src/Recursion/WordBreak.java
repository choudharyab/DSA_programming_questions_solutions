package Recursion;

import java.util.*;

public class WordBreak {
    public static boolean wordBreak(String s , List<String> wordDict){

      return wordBreakRecursion(s , new HashSet<>(wordDict),0);
    }

    public static boolean wordBreakRecursion(String s, Set<String> wordDict , int start){
        if(start == s.length()) return true;

        for(int end = start +1 ;end <=s.length();end++){
            boolean exists = wordDict.contains(s.substring(start,end));
            boolean wordExists = wordBreakRecursion(s,wordDict,end);
            if(exists && wordExists) return true;
//            if(wordDict.contains(s.substring(start,end)) && wordBreakRecursion(s,wordDict,end)){
//                return true;
//            }
        }
        return false;

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
