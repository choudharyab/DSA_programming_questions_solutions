package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
    public class TreeNode {
        int val;
        TreeNode left ;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q== null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;

        return isSameTree(p.right , q.right) && isSameTree(p.left,q.left);


    }

    public boolean isSymmetric(TreeNode root) {

        return root == null || findSymmetric(root.left , root.right);

    }

    public boolean findSymmetric(TreeNode left , TreeNode right){

        if(left == null || right == null){
            return left == right;
        }

        if(left.val != right.val) return false;

        return findSymmetric(left.left , right.right) && findSymmetric(right.left ,left.right);

    }

    public TreeNode sortedArrayToBST(int[] nums, int left , int right) {

        if(left > right) return  null ;

        int mid = (left + right)/2;
        TreeNode temp = new TreeNode(nums[mid]);

        temp.left = sortedArrayToBST(nums,left , mid-1);
        temp.right = sortedArrayToBST(nums,mid+1, right);
        return temp;
    }



    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        List<List<Integer>>  addAllList = new ArrayList<>();

        if(root == null) return addAllList;
        que.offer(root);

        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> list = new LinkedList<Integer>();
            for(int i=0; i< size;i++){
                if(que.peek().left != null){
                    que.offer(que.peek().left);
                }
                if(que.peek().right != null){
                    que.offer(que.peek().right);
                }
                list.add(que.poll().val);
            }
            addAllList.add(list);
        }
        //Collections.reverse(addAllList);  //levelOrderBottom read
        return addAllList;

    }

    public static void main(String[] args) {
        Tree t = new Tree();
        int[] nums = {-10,-3,0,5,9};

        TreeNode ans = t.sortedArrayToBST(nums,0, nums.length-1);
        System.out.println(ans);

    }
}
