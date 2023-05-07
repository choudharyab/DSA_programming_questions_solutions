package Tree;

import java.util.ArrayList;
import java.util.List;

class BottomLeftNode {
    int val;
    BottomLeftNode left , right;

    BottomLeftNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class BottomLeftTree {
    BottomLeftNode root;
    int mostBottom  = 0 ;
    List<Integer> leftStack = new ArrayList<>();
    public int findBottomLeftValue(BottomLeftNode root) {
        findBottomLeft(root , 0,leftStack);
        return mostBottom;
    }

    public  void findBottomLeft(BottomLeftNode root , int level, List<Integer> leftStack){

        if(root == null) return;

        if(leftStack.size() == level){
            leftStack.add(root.val);
            mostBottom = root.val;
        }

        findBottomLeft(root.left , level +1,leftStack);
        findBottomLeft(root.right , level+1, leftStack);



    }


    public static void main(String[] args) {
        BottomLeftTree tree = new BottomLeftTree();
        tree.root = new BottomLeftNode(1);
        tree.root.left = new BottomLeftNode(2);
        tree.root.right = new BottomLeftNode(3);
        tree.root.left.right = new BottomLeftNode(4);
        tree.root.right.left = new BottomLeftNode(5);
        tree.root.right.right = new BottomLeftNode(6);
        tree.root.right.right.left = new BottomLeftNode(7);

        int ans = tree.findBottomLeftValue(tree.root);
        System.out.println(ans);
    }
}
