package Array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
       List<List<Integer>> ans = new ArrayList<>();
       for(int i = 1 ; i<=numRows;i++){
           ans.add(generateRow(i));
       }
       return ans;
    }

    static List<Integer> generateRow(int row){
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);
        long ans = 1 ;
        for(int col = 1 ;col<row;col++){
            ans = ans *(row -col );
            ans = ans /col;
            ansRow.add((int) ans);
        }

        return  ansRow;

    }
    public static void main(String[] args) {
        int n = 5 ;
        List<List<Integer>> ans = generate(5);
        System.out.println(ans);

    }
}
