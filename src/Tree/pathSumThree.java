package Tree;

class pathSumThreeNode {
    int val ;
    pathSumThreeNode left , right;

    pathSumThreeNode(int val){
        this.val = val;
        this.right = null;
        this.left = null;
    }
}

public class pathSumThree {
    pathSumThreeNode root;
    int pathSumCount = 0;

    public int pathSum(pathSumThreeNode root , int target){
        getSum(root, 0 , target);
        System.out.println(pathSumCount);
        return pathSumCount;

    }

    public void getSum(pathSumThreeNode root  , int currentSum , int target){
        if(root == null) return ;

        currentSum += root.val;
        if(currentSum > target){
            currentSum -= root.val;
        }

        if(root.left == null && root.right == null){
            if(currentSum == target){
                pathSumCount++;
            }else{
                return;
            }
        }

        if(root.left != null){
            getSum(root.left,currentSum,target);
        }

        if(root.right != null){
            getSum(root.right,currentSum,target);
        }
    }

    public static void main(String[] args) {
        pathSumThree tree = new pathSumThree();
//        tree.root = new pathSumThreeNode(10);
//        tree.root.left = new pathSumThreeNode(5);
//        tree.root.right = new pathSumThreeNode(-3);
//        tree.root.left.left = new pathSumThreeNode(3);
//        tree.root.left.right = new pathSumThreeNode(2);
//        tree.root.left.left.left = new pathSumThreeNode(3);
//        tree.root.left.left.right = new pathSumThreeNode(-2);
//        tree.root.left.right.right = new pathSumThreeNode(1);
//        tree.root.right.right = new pathSumThreeNode(11);
        tree.root = new pathSumThreeNode(5);
        tree.root.left = new pathSumThreeNode(4);
        tree.root.right = new pathSumThreeNode(8);
        tree.root.left.left = new pathSumThreeNode(11);
        tree.root.right.left = new pathSumThreeNode(13);
        tree.root.right.right = new pathSumThreeNode(4);
        tree.root.left.left.left = new pathSumThreeNode(7);
        tree.root.left.left.right = new pathSumThreeNode(2);
        tree.root.right.right.left = new pathSumThreeNode(5);
        tree.root.right.right.right = new pathSumThreeNode(1);
        tree.pathSum(tree.root , 22);

    }
}
