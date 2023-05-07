package Tree;

import java.util.ArrayList;
import java.util.List;

class RightViewNode {
    int val ;
    RightViewNode left , right;

    RightViewNode(int val){
        this.val = val;
        this.left = null ;
        this.right = null;

    }
}

public class RightViewSide {
    RightViewNode root;
    List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(RightViewNode root) {
        rightView(root, 0);
        return ans;
    }

    public void rightView(RightViewNode root , int level){
        if(root == null) return;

        if(ans.size() == level) ans.add(root.val);

        rightView(root.right , level+1);
        rightView(root.left , level +1);


    }


    public static void main(String[] args) {
        RightViewSide tree = new RightViewSide();
        tree.root = new RightViewNode(1);
        tree.root.left = new RightViewNode(2);
        tree.root.right = new RightViewNode(3);
        tree.root.left.right = new RightViewNode(5);
        tree.root.right.right = new RightViewNode(4);

        List<Integer> ansValue = tree.rightSideView(tree.root);
        System.out.println(ansValue);

    }
}
