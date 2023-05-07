package stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/*/
public class minAddToValidParathensis {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack  = new Stack<>();
        if(s.isEmpty()) return 0;
        int minAdd = 0 ;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(ch);
            }else if(ch == ')' && stack.size() != 0 && stack.peek() == '('){
                stack.pop();
            }else {
                minAdd++;

            }
        }

        if(stack.size() !=0) minAdd += stack.size();

        return minAdd;


    }

    public static void main(String[] args) {
        minAddToValidParathensis valid = new minAddToValidParathensis();
        String str = "()))((";
        int ans = valid.minAddToMakeValid(str);
        System.out.println(ans);
    }
}
