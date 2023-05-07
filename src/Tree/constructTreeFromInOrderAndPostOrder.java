package Tree;

import java.util.HashMap;
import java.util.Map;

class dummyTree {
    int val ;
    dummyTree left , right;

    dummyTree(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class constructTreeFromInOrderAndPostOrder {
    static HashMap<Integer, Integer> map
            = new HashMap<Integer, Integer>();
    static int index;


    public dummyTree buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
         index = n -1 ;
        createMapping(inorder,map,n);
        dummyTree ans = solve(inorder,postorder,0,n-1,n);
        return ans;

    }

    public dummyTree solve(int[] inorder , int[] postorder  , int startInOrderIndex, int endInorderIndex, int n){

        if( index < 0 || startInOrderIndex > endInorderIndex){
            return null;
        }

        int element = postorder[index--];
        dummyTree root = new dummyTree(element);

        if(startInOrderIndex == endInorderIndex) return root;
        int position = map.get(element);


        root.right = solve(inorder,postorder,position +1,endInorderIndex,n);
        root.left = solve(inorder,postorder,startInOrderIndex,position-1, n);

        return root;

    }

    public void createMapping(int[] inorder ,Map<Integer,Integer> map , int n){
        for(int i =0;i<n ;i++){
            map.put(inorder[i],i);
        }
    }

    static void preOrder(dummyTree node)
    {
        if (node == null)
            return;
        System.out.printf("%d ", node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        constructTreeFromInOrderAndPostOrder tree = new constructTreeFromInOrderAndPostOrder();
        int[] inorder = {9,3,15,20,7}, postorder = {9,15,7,20,3};
        dummyTree root = tree.buildTree(inorder,postorder);
        System.out.print(
                "Preorder of the constructed tree : \n");
        preOrder(root);
    }
}
