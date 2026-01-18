//https://leetcode.com/problems/separate-squares-i/description/

class Solution {
    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE;
        double high = -Double.MAX_VALUE;
        double totalArea = 0.0;

        for(int [] square : squares){
            double x = square[0];
            double y = square[1];
            double l = square[2];

            totalArea += (l * l);
            /* We are finding y axis line from low to high */
            low = Math.min(low ,y);
            high = Math.max(high,y+l);

        }

        double result = 0.0;
        while((high - low ) >= 1e-5){
            double mid_y = low + (high - low)/2.0;
            result = mid_y;

            if(check(squares,mid_y,totalArea)){
                //shift down 
                high = mid_y;
            }else{
                low = mid_y;
            }
        }

        return result;
    }

    private boolean check(int[][] squares , double mid_y , double totalArea){
        double bottomArea = 0.0 ;

        for(int [] square : squares){
            double y = square[1];
            double l = square[2];

            double botY = y ;
            double topY = y + l;

            if(mid_y >= topY){
                //full square below
                bottomArea += l* l;
            }else if(mid_y > botY){
                bottomArea += l *(mid_y - botY);
            } 


        }

        return bottomArea >= (totalArea / 2.0);

    }
}