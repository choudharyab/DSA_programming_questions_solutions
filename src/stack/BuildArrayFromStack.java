package stack;

/* https://leetcode.com/problems/build-an-array-with-stack-operations */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BuildArrayFromStack {
    enum arrayOperation {
        Push , Pop
    }
    public List<String> buildArray(int [] target , int n){
        Stack<Integer> stack = new Stack<>();
        List<String> stackOperation = new ArrayList<>();
        if(n == 0) return new ArrayList<>();
        int i = 0 , j = 0 ;
        while (i < n && j < target.length){
            stack.push(i+1);
            stackOperation.add(arrayOperation.Push.toString());
            if(target.length < n && target[j] != stack.peek()){
                stack.pop();
                stackOperation.add(arrayOperation.Pop.toString());
            }else{
                j++;
            }
            i++;
        };
        return stackOperation;

    }
    public static void main(String[] args) {
        BuildArrayFromStack buildArrayFromStack = new BuildArrayFromStack();
        int [] target = {1,2};
        int n = 4;
        List<String> ans = buildArrayFromStack.buildArray(target,n);
        System.out.println("ans------> " + ans);
    }
}

/**
 *
 * */