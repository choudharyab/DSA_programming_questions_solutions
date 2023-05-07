package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class cousinNode {
    int val ;
    cousinNode left , right;

    cousinNode(int val){
        this.val = val;
        this.left = null ;
        this.right = null;
    }
}
public class cousinTree {
    cousinNode root;

    public  boolean isCousins(cousinNode root , int x , int y){

        return (level(root ,x,1) ==  level(root,y,1)) && !isSibling(root,x,y);
    }

   public int level(cousinNode root , int x  , int level){
     if(root == null) return 0;
     if(root.val == x) return level;

     int l = level(root.left , x , level +1);
     if(l !=0) return l;

     return  level(root.right,x,level+1);
   }

    public boolean isCousinsTwo(cousinNode root, int A, int B) {
        if (root == null) return false;
        Queue<cousinNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isAexist = false;
            boolean isBexist = false;
            for (int i = 0; i < size; i++) {
                cousinNode cur = queue.poll();
                if (cur.val == A) isAexist = true;
                if (cur.val == B) isBexist = true;
                if (cur.left != null && cur.right != null) {
                    if (cur.left.val == A && cur.right.val == B) {
                        return false;
                    }
                    if (cur.left.val == B && cur.right.val == A) {
                        return false;
                    }
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            if (isAexist && isBexist)  return true;
        }
        return false;
    }

   public boolean isSibling(cousinNode root , int x , int y){

        if(root == null) return  false;

        return ((root.left.val == x && root.right.val ==y || root.left.val == y && root.left.right.val == x ||
                isSibling(root.left,x,y) || isSibling(root.right ,x,y)
                ));

   }

    public static void main(String[] args) {
        cousinTree tree = new cousinTree();
        tree.root = new cousinNode(1);
        tree.root.left = new cousinNode(2);
        tree.root.right = new cousinNode(3);
        tree.root.left.left = new cousinNode(4);

        boolean ans = tree.isCousins(tree.root,4,3);
        System.out.println(ans);
    }
}
