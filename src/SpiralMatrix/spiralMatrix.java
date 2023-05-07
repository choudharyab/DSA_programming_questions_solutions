package SpiralMatrix;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class spiralMatrix {

    static List<Integer> printMatrix(int[][] matrix){
        List<Integer> result = new ArrayList<>();
        int startRow = 0 ;
        int endRow = matrix.length - 1 ;
        int startCol  = 0 ;
        int endCol  = matrix[0].length - 1 ;

        if(matrix.length == 0 || matrix[0].length == 0) return result;

        while (startRow <= endRow && startCol <= endCol){
            //top
            for(int j=startCol; j<=endCol; j++){
                result.add(matrix[startRow][j]);
            }
            // right
            for(int i=startRow+1; i<=endRow; i++){
                result.add(matrix[i][endCol]);
            }
            // bottom
            for(int j= endCol-1; j>=startCol; j--){
                if(startRow==endRow){
                    break;
                }
                result.add(matrix[endRow][j]);
            }
            // left
            for(int i=endRow-1; i>=startRow+1; i--){
                if(startCol==endCol){
                    break;
                }
                result.add(matrix[i][startCol]);
            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }


        return  result;

    }
    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3 },
                { 4,5, 6 },
                { 7,8,9 }};
        int n  = matrix.length -1;   //row length
        int m  = matrix[0].length-1;   // col length
        List<Integer> result = printMatrix(matrix);
        System.out.println(result);

    }
}
