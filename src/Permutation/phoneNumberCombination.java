package Permutation;

import java.util.ArrayList;
import java.util.List;

public class phoneNumberCombination {
    public static void main(String[] args) {
        letterCombinations("7");

        System.out.println(letterCombinations("7"));
    }

    static List<String> letterCombinations(String digits) {

        return combinationPhone(new String(),digits);

    }

    static List<String> combinationPhone(String p , String up){
        if(up.isEmpty()){
            List<String> list = new ArrayList<>();
            if(up.isEmpty() && !p.isEmpty()) {
                list.add(p);
            }
            return (ArrayList) list;
        }

        List<String> list = new ArrayList<>();
        int digit = up.charAt(0) - '0';   //convert string into number
        if(digit == 7 || digit == 9){
            for(int i = (digit -1) * 3;i<= digit*3;i++){
                char ch = (char)('a'+i-3);
                list.addAll(combinationPhone(p+ch,up.substring(1)));

            }
        }else {
            for(int i = (digit -1)* 3 ;i<digit *3 ;i++){
                if(digit == 8){
                    char ch =(char)('a'+i-2);
                    list.addAll(combinationPhone(p + ch, up.substring(1)));

                }else {
                    char ch = (char) ('a' + i - 3);
                    list.addAll(combinationPhone(p + ch, up.substring(1)));
                }
            }
        }
        return (ArrayList) list;
    }


}

/*
23
1  0
2  abc  0 1 2 3
3  def  3 4 5 6
4  ghi  6 7 8 9
5  jkl  9 10 11 12
6  mno  12 13 14  15      15 16 17 18
7  pqrs  15 16 17 18 19    18 19 20 21
8  tuv   19 20 21 22
9  wxyz 22 23 24 25 26

ad,ae,af,bd,be,bf,cd,ce,cf
* */

