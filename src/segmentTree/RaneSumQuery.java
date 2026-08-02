/*https://leetcode.com/problems/range-sum-query-mutable/?envType=problem-list-v2&envId=segment-tree */
class NumArray {
    int [] tree;
    int [] nums;
    int n;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = nums.clone();
        this.tree = new int[n*4];
        build(0,0,n-1);
        
    }

    private void build(int node , int left, int right){
        if(left == right){
            tree[node] = nums[left];
            return;
        }
        int mid = (left + right)/2;
        build(2 * node +1 , left,mid);
        build(2 * node +2,mid+1,right);
        tree[node] = tree[2 * node +1] + tree[2 * node +2];
    }
    
    public void update(int index, int val) {
        updateTree(index,val,0,0,n-1);
        
    }

    private void updateTree(int index , int val , int node, int start,int end){
        
        if(start == end){
            tree[node] = val;
            return;
        }
        
        int mid = (start + end) /2 ;

        if(index <= mid){
            updateTree(index,val, 2 * node +1,start,mid);
        }else{
            updateTree(index,val,2*node +2 , mid+1,end);
        }
        tree[node] = tree[2 * node +1] + tree[2 * node +2];
    }
    
    public int sumRange(int left, int right) {
        return query(0,0,n-1,left,right);
    }

    private int query(int node , int start,int end , int left, int right){
        if(left > end || right < start) return 0;
        if(start >= left && end <= right) return tree[node];

        int mid = (start + end)/2;

        return query(2 * node +1 , start,mid,left,right) + query(2 * node +2 , mid+1,end,left,right);

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */