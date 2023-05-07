package Tree;

class sumNode {
    int val ;
    sumNode left , right;

    sumNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class MaximuSumlevel {
    sumNode root;
    int maxSum = 0;
    public int maxLevelSum(sumNode root) {
            solve(root , 0,0,0,0);
            return  maxSum;
    }

    public void  solve(sumNode root , int maxSum , int currSum , int maxSumLevel , int level){
        if(root == null) return ;

        currSum = root.val;
        if(currSum > maxSum) maxSum = currSum; maxSumLevel = level;

         solve(root.left , maxSum , currSum , maxSumLevel,level+1);
         solve(root.right , maxSum,currSum,maxSumLevel, level+1);
    }


        public static void main(String[] args) {
        MaximuSumlevel tree = new MaximuSumlevel();
        tree.root = new sumNode(1);
        tree.root.left = new sumNode(7);
        tree.root.right = new sumNode(0);
        tree.root.left.left = new sumNode(7);
        tree.root.left.right = new sumNode(-8);

        int ans = tree.maxLevelSum(tree.root);
        System.out.println(ans);
    }
}
