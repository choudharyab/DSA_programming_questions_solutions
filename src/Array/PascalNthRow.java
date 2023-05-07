package Array;

import java.util.ArrayList;
import java.util.List;

public class PascalNthRow {
    public static List<Integer> pascalTriangle(int n){
        List<Integer> ans = new ArrayList<>();
        for(int c =1 ;c <=n ;c++){
            ans.add(generateRowForIndex(n-1,c-1));
        }
        return ans;
    }
    public static int generateRowForIndex(int n , int col){
        long ans = 1 ;
        for(int c =0 ;c <col ;c++){
            ans = ans *(n-c);
            ans = ans /(c+1);
        }
        return (int) ans;

    }
    public static void main(String[] args) {
        int n = 4 ;
        List<Integer> ans = pascalTriangle(n);
        System.out.println(ans);
    }
}
