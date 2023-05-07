package Tree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNodeDepth {
    int data;
    TreeNodeDepth left , right;

    TreeNodeDepth(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class pairItem {
    TreeNodeDepth node ;
    int depth;

    pairItem(TreeNodeDepth node ,int depth){
        this.depth = depth;
        this.node = node;
    }
}

/**
 * check root node is null return 0
 * check the left node/right node  is null return 1
 * check if left node is null traverse right +1
 * check if right node is null traverse left + 1
**/
public class MinimumDepth {
    TreeNodeDepth root;

    static int minimumDepth(TreeNodeDepth root){
        if(root == null) return 0;

        if(root.left == null && root.right == null) return  1;

        if(root.left == null){
            return minimumDepth(root.right) + 1;
        }

        if(root.right == null){
            return minimumDepth(root.left) + 1 ;
        }

        return Math.min(minimumDepth(root.left),minimumDepth(root.right)) + 1;

    }

    static  int minimumDepth2(TreeNodeDepth root){
        if(root == null) return 0;

        Queue<pairItem> que = new LinkedList<>();

        pairItem pt = new pairItem(root ,1);
        que.add(pt);

        while (!que.isEmpty()){
            pt = que.peek();
            que.remove();

            TreeNodeDepth node = pt.node;
            int depth = pt.depth;

            if(root.left == null && root.right == null) return depth;

            if(root.left != null){
                pt.node = root.left;
                pt.depth = depth + 1 ;
                que.add(pt);
            }

            if(root.right != null){
                pt.node = root.right;
                pt.depth = depth + 1 ;
                que.add(pt);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MinimumDepth tree = new MinimumDepth();
        tree.root = new TreeNodeDepth(3);
        tree.root.left = new TreeNodeDepth(9);
        tree.root.right = new TreeNodeDepth(20);
        tree.root.right.left = new TreeNodeDepth(15);
        tree.root.right.right = new TreeNodeDepth(7);

        int ans = minimumDepth(tree.root);
        System.out.println(ans);
    }
}
