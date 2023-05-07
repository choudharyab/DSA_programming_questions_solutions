package Tree;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map.Entry;

class levelTree {
    int val ;
    levelTree left , right;

    levelTree(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class maximumLevel {

    levelTree root;

    public int maxLevelSum(levelTree root){
        HashMap<Integer,Integer> map = new HashMap<>();
        int level = 0;
        int maxSum = 0;
        int findingLevel = 0;
        int ans = solve(root, level , map, maxSum,0,findingLevel);
        System.out.println(ans);
//        int maxValueInMap = (Collections.max(map.values()));
//        for(Entry<Integer, Integer> entry: map.entrySet()) {
//              if(entry.getValue() == maxValueInMap){
//                  level = entry.getKey() ;
//                  break;
//              }
//        }
        return ans;

    }

    public int solve(levelTree root , int level ,HashMap<Integer,Integer> map,int maxSum,int currSum,int findingLevel) {
        if (root == null) return 0;

        currSum = root.val;
        if(map.containsKey(level)){
            int numSum = map.get(level) + currSum;
            if(numSum > maxSum){
                maxSum = numSum;
                findingLevel = level;
            }
            map.put(level,numSum);
        }else {
            map.put(level,currSum);
            if(currSum > maxSum){
                maxSum = currSum;
                findingLevel = level;
            }
        }

        Queue<levelTree> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            int size = que.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                levelTree node = que.peek();
                que.remove();
               // currSum += node.val;

                if (node.left != null) {
                    solve(node.left, level + 1, map, maxSum,currSum,findingLevel);
                }

                if (node.right != null) {
                    solve(node.right, level + 1, map, maxSum,currSum,findingLevel);
                }
            }
        }
        return findingLevel +1;
    }

    public static void main(String[] args) {
        maximumLevel tree = new maximumLevel();
        tree.root = new levelTree(1);
        tree.root.left = new levelTree(7);
        tree.root.right = new levelTree(0);
        tree.root.left.left = new levelTree(7);
        tree.root.left.right = new levelTree(-8);
//        tree.root.right.left = new levelTree(-7);
//        tree.root.right.right = new levelTree(9);

        int ans = tree.maxLevelSum(tree.root);
        System.out.println(ans);
    }
}
