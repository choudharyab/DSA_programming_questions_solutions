package stack;

import java.util.Stack;

/*https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/*/
public class minSwapToBalancedString {
    public int minSwaps(String s) {
        Stack<Character> stack  = new Stack<>();
        if(s.isEmpty()) return 0;

        for(char ch : s.toCharArray()){
            if(ch == '['){
                stack.push(ch);
            }else if(ch == ']' && stack.size() != 0 && stack.peek() == '['){
                stack.pop();
            }
        }

        if(stack.size()%2 == 0) {
            return stack.size()/2;
        }else {
            return (stack.size() +1)/2;
        }

    }
    public static void main(String[] args) {
        minSwapToBalancedString swapMin = new minSwapToBalancedString();
       // String str = "]]][[[";
        String str ="())";
        int ans = swapMin.minSwaps(str);
        System.out.println(ans);
    }
}

/*] ] ] [ [ [
  [ ] ] ] [ [
  [ [ ] ] ] ]
* **/