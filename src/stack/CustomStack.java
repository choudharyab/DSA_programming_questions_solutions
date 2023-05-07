package stack;

import java.util.Stack;

class CustomStack {
    int n ;
    int[] inc;
    Stack<Integer> stack;

    public CustomStack(int maxSize) {
        n = maxSize;
        inc =  new int[n];
        stack = new Stack<>();

    }

    public void push(int x) {
        if(stack.size() < n) stack.push(x);

    }

    public int pop() {
        int popped = stack.size() - 1;
        if(popped < 0) return -1;
        if(popped > 0){
            inc[popped -1] += inc[popped];
        }
        int res = stack.pop() + inc[popped];
        inc[popped] = 0;
        return res;


    }

    public void increment(int k, int val) {
        int incrementValue = Math.min(k, stack.size()) - 1 ;
        if(incrementValue >= 0){
            inc[incrementValue] +=val;
        }

    }

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3);
        customStack.push(5);
        int popped = customStack.pop();
        customStack.increment(5,100);

    }
}
/*
["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
[[3],[1],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]

* ***/