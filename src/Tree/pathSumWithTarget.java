package Tree;

import java.util.ArrayList;
import java.util.List;

class pathSumTree {
    pathSumTree left ,right ;
    int data ;

    pathSumTree(int data){
        this.data = data;
        this.left = null ;
        this.right = null ;
    }

}

public class pathSumWithTarget {
    pathSumTree root;
    List<List<Integer>> resAllList = new ArrayList<>();


    static boolean hasPathSum(pathSumTree root , int target){
        if(root == null) return  false ;
        boolean ans = false ;

        int sum = target - root.data;
        if(sum == 0 && root.left == null && root.right == null) return true;

        if(root.left != null){
            ans = ans || hasPathSum(root.left , sum);
        }

        if(root.right != null){
            ans = ans || hasPathSum(root.right , sum);
        }

        return  ans;
    }
     public List<List<Integer>> hasPathSumTwo(pathSumTree root , int target){

        getSumPath(root , new ArrayList<Integer>(), 0 , target);
        System.out.println(resAllList);
        return resAllList;
    }

    public  void getSumPath(pathSumTree root , List<Integer> list , int current , int target) {

        if(root == null) return;

        current += root.data;
        list.add(root.data);

        if(root.left == null && root.right == null){
            if(current == target) {
                resAllList.add(list);
            }else {
                return;
            }
        }

        if(root.left != null){
            getSumPath(root.left , new ArrayList<Integer>(list), current, target);
        }

        if(root.right != null){
            getSumPath(root.right , new ArrayList<Integer>(list), current, target);
        }

    }




    public static void main(String[] args) {
        pathSumWithTarget tree = new pathSumWithTarget();
        tree.root = new pathSumTree(5);
        tree.root.left = new pathSumTree(4);
        tree.root.right = new pathSumTree(8);
        tree.root.left.left = new pathSumTree(11);
        tree.root.right.left = new pathSumTree(13);
        tree.root.right.right = new pathSumTree(4);
        tree.root.left.left.left = new pathSumTree(7);
        tree.root.left.left.right = new pathSumTree(2);
        tree.root.right.right.right = new pathSumTree(1);

        boolean ans = hasPathSum(tree.root , 22);
        tree.hasPathSumTwo(tree.root , 22);
    }
}
