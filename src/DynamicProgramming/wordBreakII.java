package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class wordBreakII {
    

    public  List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        return recursiveCallWordCheck(s,0,wordDict,map);

    }

    private List<String> recursiveCallWordCheck(String s , int startIndex , List<String> wordDict,HashMap<Integer, List<String>> map){
        ArrayList<String> ans = new ArrayList<>();


        if(map.containsKey(startIndex)){
            return map.get(startIndex);
        }

        if(startIndex == s.length()) ans.add("");

        for(int i = startIndex +1 ;i<=s.length() ;i++){
            String word = s.substring(startIndex,i);
            if(wordDict.contains(word)){
                List<String> arr = recursiveCallWordCheck(s,i,wordDict,map);
                for(String str1 : arr){
                    ans.add(word + (str1.equals("") ? "" : " ") + str1);
                }
            }

        }
        map.put(startIndex , ans);
        return ans;

    }

    public static void main(String[] args) {
        String str = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        wordBreakII wordclass = new wordBreakII();
        List<String> sentences = wordclass.wordBreak(str,wordDict);
        System.out.println("sentences "+wordclass.wordBreak(str,wordDict));
    }
}

/*
*  catsanddog
*  catsand
* */
