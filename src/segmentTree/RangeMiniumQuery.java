/* The functions which
builds the segment tree 
https://www.geeksforgeeks.org/problems/range-minimum-query/1
*/
class GfG {
     int st[];
    
    public  int[] constructST(int arr[], int n) {
        st = new int[4 * n];
        buildTree(0,0,n-1,arr);
        return st;
    }
    
    private void buildTree(int node , int left , int right , int [] arr){
        if(left == right){
            st[node] = arr[left];
            return;
            
        }
        
        int mid = (left + right) /2 ;
        buildTree(2 * node +1 , left , mid,arr);
        buildTree(2 * node +2 , mid+1, right,arr);
        
        st[node] = Math.min(st[2 * node +1],st[2 * node +2]);
    }

    /* The functions returns the
      min element in the range
      from l and r */
    public  int RMQ(int st[], int n, int l, int r) {
        return query(0,0,n-1,l,r);
    }
    
    private int query(int node, int start, int end, int left, int right) {

    // No overlap
    if (left > end || right < start)
        return Integer.MAX_VALUE;

    // Complete overlap
    if (left <= start && end <= right)
        return st[node];

    int mid = (start + end) / 2;

    return Math.min(
        query(2 * node + 1, start, mid, left, right),
        query(2 * node + 2, mid + 1, end, left, right)
    );
}
}