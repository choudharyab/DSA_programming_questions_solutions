package Tree;

 class TreeNode {
    int data ;
    TreeNode left , right;

    TreeNode(int d){
        this.data = d;
        this.left = null;
        this.right = null;
    }
}

public class BalancedTree {
    TreeNode root;

    static boolean isBalanced (TreeNode root){
        if(root == null) return  true;

        int left = height(root.left);
        int right = height(root.right);

        if(Math.abs(left -right) <=1 && isBalanced(root.left) && isBalanced(root.right)) return  true;

        return  false;
    }

    static int isbalanced(TreeNode root){
        if(root == null) return 0;

        int left = isbalanced(root.left);
        if(left == -1) return -1;
        int right = isbalanced(root.right);
        if(right == -1) return -1;
        int diff = Math.abs(left - right);
        if(diff > 1) return -1;
        return Math.max(left,right)+1;

    }

    static int height(TreeNode root){
        if(root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left,right) + 1 ;
    }

    public static void main(String[] args) {
        BalancedTree tree = new BalancedTree();
        tree.root = new TreeNode(3);
        tree.root.left = new TreeNode(9);
        tree.root.right = new TreeNode(20);
        tree.root.right.left = new TreeNode(15);
        tree.root.right.right = new TreeNode(7);

        boolean ans = isBalanced(tree.root);
        System.out.println(ans);
        int height = isbalanced(tree.root);
        System.out.println(height);
    }
}
