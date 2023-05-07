package DynamicProgramming;

public class BeautifulArrangement {
    int count = 0;
    public  int countArrangement(int n ){
        int [] arr = new int[n];
        for(int i= 0 ;i<n ;i++){
            arr[i] = i+1;
        }
        permutate(arr, 0);
        return count;
    }

    public  void permutate(int [] arr , int index){
        if(index == arr.length && isValid(arr)) count++;
        for(int i =index;i< arr.length;i++){
            swap(arr,i,index);
            permutate(arr, index+1);
            swap(arr, i , index);
        }
    }

    public  void swap(int [] arr , int i , int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public  boolean isValid(int [] arr){
        for(int k = 0 ;k< arr.length;k++){
            if((k+1) % arr[k] == 0 || arr[k] % (k+1) == 0){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 3 ;
        BeautifulArrangement bt = new BeautifulArrangement();
        int ans = bt.countArrangement(n);
        System.out.println("ans----->" + ans);
    }
}
