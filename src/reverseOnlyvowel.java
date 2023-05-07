import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/reverse-vowels-of-a-string/description/
public class reverseOnlyvowel {

    public static String reverseVowels(String s) {
        int start = 0 ;
        int end  = s.length() - 1 ;
        List<Character> list= Arrays.asList('a', 'e', 'i','o','u','A','E','I','O','U');
        char[] ch=s.toCharArray();

        while(start < end){
            if(list.contains(ch[start]) && list.contains(ch[end])) {
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;end--;
            }else if(list.contains(ch[start]) && !list.contains(ch[end])) {
                end--;
            }else if(!list.contains(ch[start]) && list.contains(ch[end])){
                start++;
            }else if(!list.contains(ch[start]) && !list.contains(ch[end])){
                start++;end--;
            }
        }
        String str = String.valueOf(ch);
        return str;
    }
    public static void main(String[] args) {
        String s = "hello";
        String ans = reverseVowels(s);
        System.out.println(ans);
    }
}
