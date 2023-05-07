package stack;

import java.util.Arrays;
import java.util.Stack;

/* https://leetcode.com/problems/removing-stars-from-a-string/*/
public class removingStarFromString {
    public String removeStars(String s) {
        Stack<String> stack = new Stack<>();

        if(s.length() == 0) return "";

        for(char ch : s.toCharArray()){
            if(ch != '*'){
                stack.push(String.valueOf(ch));
            }else {
                stack.pop();
            }
        }
        StringBuilder st = new StringBuilder();
        for(int i = 0 ; i<stack.size();i++){
            st.append(stack.get(i));
        }

        return st.toString();
    }

    public static void main(String[] args) {
        String str = "erase*****";
        removingStarFromString rs = new removingStarFromString();
        String ans = rs.removeStars(str);
        System.out.println("printing "+ans);
    }
}
