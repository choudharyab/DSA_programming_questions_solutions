package Tree;

//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
/*
* Time complexity O(n)
* Space Complexity O(1)
* */
public class FlatternBinaryTree {

    public void flatten(TreeNode root) {
        TreeNode current = root;
        while(current != null){
            if(current.left != null){
                TreeNode precedecessor =  current.left;
                while(precedecessor.right != null && precedecessor.right != current){
                    precedecessor = precedecessor.right;
                }
                precedecessor.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }

    public static void main(String[] args) {
        FlatternBinaryTree tree = new FlatternBinaryTree();
        tree.flatten(null);
    }
}
