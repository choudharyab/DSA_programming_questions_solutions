import java.util.Arrays;

public class ProductArrayExceptSelf {
    public static  int[] bruteForce(int[] arr , int n ){
        int [] product = new int[n];
        for(int i = 0 ;i< n-1 ;i++){
            int productSelf = 1 ;
            for(int j= 0 ;j< n-1 ;j++){
                if(i == j) continue;
                productSelf = productSelf * arr[j];
            }
            product[i] = productSelf;
        }

        return product;
    }

    public  static int [] optimized(int[] arr , int n){
        int [] product = new int[n];
        product[0] = 1 ;
        for(int i=1 ;i< n ;i++){
            product[i] = arr[i-1] * product[i-1];
        }

        int suffix = 1 ;
        for(int j= n-1 ;j>=0 ;j--){
            product[j] = product[j] * suffix;
            suffix = suffix * arr[j];
        }

        return product;

    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int n = arr.length;
        int[] ans = optimized(arr , n);
        System.out.println("ans------> " + Arrays.toString(ans));
    }
}
