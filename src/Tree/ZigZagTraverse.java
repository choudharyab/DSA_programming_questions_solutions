package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ZigZagTreeNode {
    int val ;
    ZigZagTreeNode left , right;

    ZigZagTreeNode(int val){
        this.val = val;
        this.left = null ;
        this.right = null;
    }
}

public class ZigZagTraverse {
    ZigZagTreeNode root;

    public List<List<Integer>> zigzagLevelOrder(ZigZagTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<ZigZagTreeNode> que = new LinkedList<>();
        boolean leftToRight = true;
        if(root == null) return result;

        que.add(root);   //root push kiya que mein

        while (!que.isEmpty()){    //que ko tab tak check karna hai jab tak empty na ho
            int size = que.size();   // need size for traverse in node
            int[] ansStore = new int[size];  // array intialize for store value at index
            List<Integer> ans = new ArrayList<>();   // array data ko list mein push karne ke liye
            for(int i =0 ;i< size ;i++){
                ZigZagTreeNode node = que.peek();    // retrieves data from que
                que.remove();                        // remove from que

                int index = leftToRight ? i : size - i -1;     // index to know traverese
                ansStore[index] = node.val;                 // store value according to traverse

                if(node.left != null){
                    que.add(node.left);
                }

                if(node.right != null){
                    que.add(node.right);
                }


            }

            leftToRight = !leftToRight;
            for (int row: ansStore) {
                ans.add(row);
            }
            result.add(ans);

        }
        return  result;
    }


        public static void main(String[] args) {
        ZigZagTraverse tree = new ZigZagTraverse();
        tree.root = new ZigZagTreeNode(3);
        tree.root.left = new ZigZagTreeNode(9);
        tree.root.right = new ZigZagTreeNode(20);
        tree.root.right.left = new ZigZagTreeNode(15);
        tree.root.right.right = new ZigZagTreeNode(7);

        List<List<Integer>> ans = tree.zigzagLevelOrder(tree.root);
        System.out.println(ans);
    }
}
