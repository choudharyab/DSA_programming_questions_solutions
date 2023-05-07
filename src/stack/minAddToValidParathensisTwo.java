package stack;

import java.util.Stack;
/* https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/description/*/
/*https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/solutions/780291/java-linear-loop-and-o-1-space/*/
public class minAddToValidParathensisTwo {
    public int minInsertions(String s){
        if(s.isEmpty()) return 0;
        int makeValid = 0 ;
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ;i < s.length() ;i ++){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else {
                if (s.charAt(i) == ')'  && (i+1)< s.length() && s.charAt(i+1) == ')') {
                    if(!stack.isEmpty()){
                        stack.pop();
                    }else{
                        makeValid++;
                    }
                    i++;
                }else if(s.charAt(i) ==')' && (i+1) < s.length()  && s.charAt(i+1) != ')') {
                    if(!stack.isEmpty()){
                        stack.pop();
                        makeValid++;
                    }else{
                        makeValid +=2 ;
                    }
                }
            }
        }
        int doubleStack = 0 ;
        if(stack.size() != 0){
            doubleStack = stack.size() * 2;
        }
        return (makeValid + doubleStack);

    }

    public int minInsertions2(String s) {
        int res = 0, right = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                if (right % 2 > 0) {
                    right--;
                    res++;
                }
                right += 2;
            } else {
                right--;
                if (right < 0) {
                    right += 2;
                    res++;
                }
            }
        }
        return right + res;
    }
    public static void main(String[] args) {
        minAddToValidParathensisTwo valid = new minAddToValidParathensisTwo();
        String str = "(()))";
        int ans = valid.minInsertions(str);
        System.out.println(ans);
    }
}
