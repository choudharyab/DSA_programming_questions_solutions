public class IntegerBreak {
    public static int integerBreak(int n) {
        if( n ==2 || n == 3) return (n-1);
        int res = 1;
        while(n > 4) {
            n -= 3 ;
            res *= 3 ;
        }
        return (n * res);
    }
    public static void main(String[] args) {
        int n = 10 ;
        int ans = integerBreak(n);
        System.out.println(ans);
    }
}
/*
*   n = 10
*     9   1    1
*     7   2    2
*     4   3    3
* */