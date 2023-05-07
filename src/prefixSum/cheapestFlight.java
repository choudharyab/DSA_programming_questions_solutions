package prefixSum;

public class cheapestFlight {

    public static  int findCheapestPrice(int n , int [][] flights,int src , int dest , int k){
        return 0 ;
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src =  0 ;
        int dest = 3;
        int k = 1;
        int lowestPrice = findCheapestPrice(n,flights,src,dest,k);
        System.out.println(lowestPrice);
    }
}
