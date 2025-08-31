//https://leetcode.com/problems/knight-dialer/description/
class SolutionWithRecursion {
    private static final int mod = 1000000007;
    private static final List<List<Integer>> adj = Arrays.asList(
        Arrays.asList(4, 6), //0
        Arrays.asList(6, 8), //1
        Arrays.asList(7, 9),  //2
        Arrays.asList(4, 8),  //3
        Arrays.asList(3, 9, 0), //4
        Arrays.asList(),  //5
        Arrays.asList(1, 7, 0), //6
        Arrays.asList(2, 6),  //7
        Arrays.asList(1, 3), //8
        Arrays.asList(2, 4)  //9
    );
     
    public int knightDialer(int n){
        int result = 0 ;
        for(int cell = 0 ;cell <= 9 ;cell++){
            result = (result + solve(n,0)) % mod;
        }
        return result;
     }
    private int solve(int n , int currentCell){
        if(n == 0) return 1 ;
        int result = 0 ;
        for(int nextCell :adj.get(currentCell)){
            result = (result + solve(n-1,nextCell)) % mod;
        }
        return result;
    }
}

//top down approach
class Solution {
    private static final int mod = 1000000007;
    private static final List<List<Integer>> adj = Arrays.asList(
        Arrays.asList(4, 6), //0
        Arrays.asList(6, 8), //1
        Arrays.asList(7, 9),  //2
        Arrays.asList(4, 8),  //3
        Arrays.asList(3, 9, 0), //4
        Arrays.asList(),  //5
        Arrays.asList(1, 7, 0), //6
        Arrays.asList(2, 6),  //7
        Arrays.asList(1, 3), //8
        Arrays.asList(2, 4)  //9
    );
    //memoization
    public int knightDialerMemo(int n) {
        int[][] t = new int[n+1][10];
        for(int [] row : t){
            Arrays.fill(row,-1);
        }
        int result = 0 ;
        for(int cell = 0 ; cell <= 9 ;cell++){
            result = (result + solve(n-1 ,cell,t)) % mod;
        }
        return result;
    }

    private int solve(int n , int currentCell, int [][] t){
        if(n == 0) return 1 ;
        int result = 0 ;
        if(t[n][currentCell] != -1) return t[n][currentCell];
        for(int nextCell :adj.get(currentCell)){
            result = (result + solve(n-1,nextCell,t)) % mod;
        }
            
        
        return t[n][currentCell] = result;
    }
}

//bottom up approach
class Solution {
    private static final int mod = 1000000007;
    private static final List<List<Integer>> adj = Arrays.asList(
        Arrays.asList(4, 6), //0
        Arrays.asList(6, 8), //1
        Arrays.asList(7, 9),  //2
        Arrays.asList(4, 8),  //3
        Arrays.asList(3, 9, 0), //4
        Arrays.asList(),  //5
        Arrays.asList(1, 7, 0), //6
        Arrays.asList(2, 6),  //7
        Arrays.asList(1, 3), //8
        Arrays.asList(2, 4)  //9
    );
     //tabulation
     public int knightDialer(int n){
        int result = 0 ;
        int [][] t = new int[n][10];
        for(int cell = 0 ; cell < 10 ;cell++){
            t[0][cell] = 1; //base case when n = 0
        }

        for(int i = 1 ; i< n ;i++){
            for(int cell= 0 ;cell <= 9 ;cell++){
                int ans = 0 ;
                for(int nextCell : adj.get(cell)){
                    ans = (ans + t[i-1][nextCell]) % mod;
                }
                t[i][cell] = ans;
            }

        }

        for(int cell = 0 ;cell <= 9 ;cell++){
            result = (result + t[n-1][cell]) % mod;
        }
        return result;
     }
}