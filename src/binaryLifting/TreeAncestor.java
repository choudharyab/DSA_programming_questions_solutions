//https://leetcode.com/problems/kth-ancestor-of-a-tree-node/
//T.C : O(Q * log(n)) , Q = number of queries , n = number of nodes
//S.C : O(n * log(n)) to store events in map
class TreeAncestor {
    //rows = n
    // cols = log2n +1
    private final int [][] ancestorTable;
    private final int LOG;
    public TreeAncestor(int n, int[] parent) {
        LOG = (int) (Math.log(n) / Math.log(2)) + 1;
        ancestorTable = new int[n][LOG];

        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < LOG ;j++){
              ancestorTable[i][j] = -1;  
            }
        }
        //fill the 0th column first -> immediate parent(ancestor)
        for(int i = 0 ; i< n ;i++){
            ancestorTable[i][0] = parent[i];
        }

        for(int j = 1 ; j < LOG;j++){
            for(int v= 0 ; v < n ;v++){
                int prev = ancestorTable[v][j-1]; //prev node
                if(prev != -1){
                    ancestorTable[v][j] = ancestorTable[prev][j-1];
                }
            }
        }

    }
    
    public int getKthAncestor(int node, int k) {
        for(int j = 0 ; j< LOG && node != -1 ;j++){
            if((k & (1 << j)) != 0){   // finding the bits
                node = ancestorTable[node][j];
                if(node == -1) return -1;
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */