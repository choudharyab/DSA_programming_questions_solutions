package Tree;

import java.util.*;

class verticalTraversalNode {
    int val ;
    verticalTraversalNode left , right;

    verticalTraversalNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;

    }
}

 class pairVerticalNode {
    int row ;
    int col ;
    verticalTraversalNode node ;

    pairVerticalNode(verticalTraversalNode _node ,int _row , int _col ){
        node = _node;
        row = _row;
        col = _col;

    }


}
public class verticaTraversal {
    verticalTraversalNode root;

    public  List<List<Integer>> verticaTraversalCall(verticalTraversalNode root){
        TreeMap < Integer, TreeMap < Integer, PriorityQueue < Integer >>> map = new TreeMap < > ();
        Queue<pairVerticalNode> queue = new LinkedList<pairVerticalNode>();
        queue.offer(new pairVerticalNode(root,0,0));
        while (!queue.isEmpty()){
            pairVerticalNode pt = queue.poll();
            verticalTraversalNode node = pt.node;
            int x = pt.row;
            int y = pt.col;

            if(!map.containsKey(x)){
                map.put(x , new TreeMap<>());
            }

            if(!map.get(x).containsKey(y)){
                map.get(x).put(y , new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);

            if(node.left != null){
                queue.offer(new pairVerticalNode(node.left , x-1 ,y+1));
            }

            if(node.right != null){
                queue.offer(new pairVerticalNode(node.right,x+1,y+1));
            }
        }

        List < List < Integer >> list = new ArrayList < > ();
        for(TreeMap<Integer , PriorityQueue<Integer>> row : map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> ps : row.values()){
                while (!ps.isEmpty()){
                    list.get(list.size() -1).add(ps.poll());
                }
            }

        }

        return  list;


    }

    public static void main(String[] args) {
        verticaTraversal tree = new verticaTraversal();
        tree.root = new verticalTraversalNode(3);
        tree.root.left = new verticalTraversalNode(9);
        tree.root.right = new verticalTraversalNode(20);
        tree.root.right.left = new verticalTraversalNode(15);
        tree.root.right.right = new verticalTraversalNode(7);

        List<List<Integer>> verticalAns = tree.verticaTraversalCall(tree.root);
        System.out.println(verticalAns);
    }
}
